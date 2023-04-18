package rp620.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.content.*;
import mindustry.entities.effect.MultiEffect;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.draw.*;
import multicraft.IOEntry;
import multicraft.MultiCrafter;
import multicraft.Recipe;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.lineAngle;
import static arc.math.Angles.randLenVectors;
import static mindustry.type.ItemStack.with;

public class RP620Blocks
{
	//Ores
	public static Block oreSulfur;

	//Craftings
	public static Block chemicalPlant;
	//public static Block
	public static void load()
	{
		//region Ores
		oreSulfur=new OreBlock("ore-sulfur",RP620Items.sulfur)
		{{
			localizedName="Sulfur";

		}};
		//endregion
		//region Craftings
		chemicalPlant =new RP620MultiCrafter("chemical-plant")
		{{
			requirements(Category.crafting,with(Items.copper,100,Items.lead,100, Items.beryllium,100));
			localizedName="Chemical Plant";
			description="Produce many chemicals";
			alwaysUnlocked=true;
			size=2;
			itemCapacity=10;
			liquidCapacity=10f;
			hasItems=true;
			health=300;
			craftEffect=new MultiEffect(Fx.vapor,Fx.smoke,Fx.bubble);
			resolvedRecipes= Seq.with(
					new Recipe(
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											Liquids.nitrogen,.2f,
											Liquids.ozone,.4f
									)),
									2
							),
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											RP620Liquids.nitrogenOxide,.2f
									))
							),
							60
					),
					new Recipe(
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											Liquids.nitrogen,.1f,
											Liquids.ozone,.2f
									)),
									2
							),
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											RP620Liquids.nitrogenDioxide,.2f
									))
							),
							60
					),
					new Recipe(
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											RP620Liquids.ammonia,.3f,
											Liquids.ozone,.2f
									)),
									2
							),
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											RP620Liquids.nitrogenDioxide,.2f, Liquids.water,.3f
									))
							),
							60
					),
					new Recipe(
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											Liquids.nitrogen,.1f,
											Liquids.hydrogen,.3f
									)),
									2
							),
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											RP620Liquids.ammonia,.2f
									))
							),
							60
					),
					new Recipe(
							new IOEntry(
									Seq.with(ItemStack.with(
											RP620Items.salt,2, Items.coal,1
									)),
									Seq.with(LiquidStack.with(
											Liquids.water,.2f
									)),
									2
							),
							new IOEntry(
									Seq.with(ItemStack.with(RP620Items.lye,2)),
									Seq.with()
							),
							60
					),
					new Recipe(
							new IOEntry(
									Seq.with(ItemStack.with(
											RP620Items.lye,3
									)),
									Seq.with(LiquidStack.with(
											Liquids.oil,.1f
									)),
									2
							),
							new IOEntry(
									Seq.with(ItemStack.with(RP620Items.soap,3)),
									Seq.with(LiquidStack.with(RP620Liquids.glycerin,.1f))
							),
							60
					),
					new Recipe(
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											RP620Liquids.nitrogenDioxide,.2f,
											Liquids.water,.1f
									)),
									2
							),
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											RP620Liquids.nitricAcid,.2f
									))
							),
							60
					),
					new Recipe(
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											RP620Liquids.nitrogenOxide,.2f,
											Liquids.ozone,.1f,
											Liquids.water,.1f
									)),
									2
							),
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											RP620Liquids.nitricAcid,.4f
									))
							),
							60
					),
					new Recipe(
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											RP620Liquids.glycerin,.3f,
											RP620Liquids.nitricAcid,.1f
									)),
									2
							),
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											RP620Liquids.nitroglycerin,.1f,
											Liquids.water,.3f
									))
							),
							60
					),
					new Recipe(
							new IOEntry(
									Seq.with(ItemStack.with(
											Items.silicon,1,
											Items.sporePod,1
									)),
									Seq.with(),
									2
							),
							new IOEntry(
									Seq.with(ItemStack.with(
											RP620Items.celluloseFiber,1
									)),
									Seq.with()
							),
							60
					),
					new Recipe(
							new IOEntry(
									Seq.with(ItemStack.with(
											RP620Items.celluloseFiber,3
									)),
									Seq.with(LiquidStack.with(
											RP620Liquids.nitroglycerin,.1
									)),
									2
							),
							new IOEntry(
									Seq.with(ItemStack.with(
											RP620Items.dynamite,1
									)),
									Seq.with()
							),
							60
					),
					new Recipe(
							new IOEntry(
									Seq.with(ItemStack.with(
											RP620Items.dynamite,1
									)),
									Seq.with(LiquidStack.with(
											RP620Liquids.nitricAcid,.8f
									)),
									2
							),
							new IOEntry(
									Seq.with(ItemStack.with(
											RP620Items.onc,1
									)),
									Seq.with(LiquidStack.with(
											Liquids.water,.7f,
												  RP620Liquids.nitrogenDioxide,.8f
									))
							),
							60
					),
					new Recipe(
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											RP620Liquids.ammonia,.2f,
											Liquids.nitrogen,.1f
									)),
									2
							),
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											Liquids.hydrogen,.1f,
											RP620Liquids.hydrazine,.1f
									))
							),
							60
					),
					new Recipe(
							new IOEntry(
									Seq.with(),
									Seq.with(LiquidStack.with(
											RP620Liquids.hydrazine,.3f,
											RP620Liquids.nitrogenDioxide,.4f
									)),
									2
							),
							new IOEntry(
									Seq.with(ItemStack.with(
											RP620Items.azidoazideAzide,1
									)),
									Seq.with(LiquidStack.with(
											Liquids.water,.6f,
											Liquids.nitrogen,.6f
									))
							),
							60
					),
					new Recipe(
							new IOEntry(
									Seq.with(ItemStack.with(
											RP620Items.azidoazideAzide,1
									)),
									Seq.with(LiquidStack.with(
											RP620Liquids.hydrazine,.4f
									)),
									2
							),
							new IOEntry(
									Seq.with(ItemStack.with(
											RP620Items.oac,1
									)),
									Seq.with(LiquidStack.with(
											Liquids.nitrogen,.4f
									))
							),
							60
					)
			);
			regionRotated1 = 3;
			//fluidOutputDirections = new int[]{1, 3};
		}};
		//endregion
	}
}
