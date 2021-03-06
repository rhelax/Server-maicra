package net.minecraft.advancements.critereon;

import com.google.gson.JsonObject;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.server.level.EntityPlayer;

public class CriterionTriggerTick extends CriterionTriggerAbstract<CriterionTriggerTick.a> {

    public static final MinecraftKey ID = new MinecraftKey("tick");

    public CriterionTriggerTick() {}

    @Override
    public MinecraftKey getId() {
        return CriterionTriggerTick.ID;
    }

    @Override
    public CriterionTriggerTick.a createInstance(JsonObject jsonobject, CriterionConditionEntity.b criterionconditionentity_b, LootDeserializationContext lootdeserializationcontext) {
        return new CriterionTriggerTick.a(criterionconditionentity_b);
    }

    public void trigger(EntityPlayer entityplayer) {
        this.trigger(entityplayer, (criteriontriggertick_a) -> {
            return true;
        });
    }

    public static class a extends CriterionInstanceAbstract {

        public a(CriterionConditionEntity.b criterionconditionentity_b) {
            super(CriterionTriggerTick.ID, criterionconditionentity_b);
        }
    }
}
