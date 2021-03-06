package net.minecraft.data;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.logging.LogUtils;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;

public class HashCache {

    private static final Logger LOGGER = LogUtils.getLogger();
    private final Path path;
    private final Path cachePath;
    private int hits;
    private final Map<Path, String> oldCache = Maps.newHashMap();
    private final Map<Path, String> newCache = Maps.newHashMap();
    private final Set<Path> keep = Sets.newHashSet();

    public HashCache(Path path, String s) throws IOException {
        this.path = path;
        Path path1 = path.resolve(".cache");

        Files.createDirectories(path1);
        this.cachePath = path1.resolve(s);
        this.walkOutputFiles().forEach((path2) -> {
            this.oldCache.put(path2, "");
        });
        if (Files.isReadable(this.cachePath)) {
            IOUtils.readLines(Files.newInputStream(this.cachePath), Charsets.UTF_8).forEach((s1) -> {
                int i = s1.indexOf(32);

                this.oldCache.put(path.resolve(s1.substring(i + 1)), s1.substring(0, i));
            });
        }

    }

    public void purgeStaleAndWrite() throws IOException {
        this.removeStale();

        BufferedWriter bufferedwriter;

        try {
            bufferedwriter = Files.newBufferedWriter(this.cachePath);
        } catch (IOException ioexception) {
            HashCache.LOGGER.warn("Unable write cachefile {}: {}", this.cachePath, ioexception.toString());
            return;
        }

        IOUtils.writeLines((Collection) this.newCache.entrySet().stream().map((entry) -> {
            String s = (String) entry.getValue();

            return s + " " + this.path.relativize((Path) entry.getKey());
        }).collect(Collectors.toList()), System.lineSeparator(), bufferedwriter);
        bufferedwriter.close();
        HashCache.LOGGER.debug("Caching: cache hits: {}, created: {} removed: {}", new Object[]{this.hits, this.newCache.size() - this.hits, this.oldCache.size()});
    }

    @Nullable
    public String getHash(Path path) {
        return (String) this.oldCache.get(path);
    }

    public void putNew(Path path, String s) {
        this.newCache.put(path, s);
        if (Objects.equals(this.oldCache.remove(path), s)) {
            ++this.hits;
        }

    }

    public boolean had(Path path) {
        return this.oldCache.containsKey(path);
    }

    public void keep(Path path) {
        this.keep.add(path);
    }

    private void removeStale() throws IOException {
        this.walkOutputFiles().forEach((path) -> {
            if (this.had(path) && !this.keep.contains(path)) {
                try {
                    Files.delete(path);
                } catch (IOException ioexception) {
                    HashCache.LOGGER.debug("Unable to delete: {} ({})", path, ioexception.toString());
                }
            }

        });
    }

    private Stream<Path> walkOutputFiles() throws IOException {
        return Files.walk(this.path).filter((path) -> {
            return !Objects.equals(this.cachePath, path) && !Files.isDirectory(path, new LinkOption[0]);
        });
    }
}
