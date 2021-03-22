package com.teamaurora.frostburn_expansion.common.entity.ai;

import java.util.EnumSet;

import com.teamaurora.frostburn_expansion.common.entity.BriskEntity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;

/**
 * Brisk
 * @author mostly mojang lol
 *
 */
public class BriskSwellGoal extends Goal {
		private BriskEntity swellingBrisk;
		private LivingEntity creeperAttackTarget;
		public BriskSwellGoal(BriskEntity entitycreeperIn) {
			this.swellingBrisk = entitycreeperIn;
			this.setMutexFlags(EnumSet.of(Flag.MOVE));
	   }
		
	   /**
	    * Reset the task's internal state. Called when this task is interrupted by another one
	    */
	   public void resetTask() {
	      this.creeperAttackTarget = null;
	   }
	   /**
	    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	    * method as well.
	    */
	   public boolean shouldExecute() {
		  if (this.swellingBrisk.isDancing) {
			  return false;
		  }
	      LivingEntity livingentity = this.swellingBrisk.getAttackTarget();
	      return this.swellingBrisk.getCreeperState() > 0 || livingentity != null && this.swellingBrisk.getDistanceSq(livingentity) < 9.0D;
	   }

	   /**
	    * Execute a one shot task or start executing a continuous task
	    */
	   public void startExecuting() {
	      this.swellingBrisk.getNavigator().clearPath();
	      this.creeperAttackTarget = this.swellingBrisk.getAttackTarget();
	   }

	   /**
	    * Reset the task's internal state. Called when this task is interrupted by another one
	    */


	   /**
	    * Keep ticking a continuous task that has already been started
	    */
	   public void tick() {
	      if (this.creeperAttackTarget == null) {
	         this.swellingBrisk.setCreeperState(-1);
	      } else if (this.swellingBrisk.getDistanceSq(this.creeperAttackTarget) > 49.0D) {
	         this.swellingBrisk.setCreeperState(-1);
	      } else if (!this.swellingBrisk.getEntitySenses().canSee(this.creeperAttackTarget)) {
	         this.swellingBrisk.setCreeperState(-1);
	      } else {
	         this.swellingBrisk.setCreeperState(1);
	      }
	   }

}
