package rp620.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.content.*;
import mindustry.entities.effect.MultiEffect;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.*;
import multicraft.DrawRecipe;
import multicraft.IOEntry;
import multicraft.MultiCrafter;
import multicraft.Recipe;
import rp620.content.RP620Classes.SimplifiedTechNode;

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
	public static Block pyratiteSmelter,cryogenicFreezer,hyperThawer,magneticSeparator;
	public static Seq<SimplifiedTechNode> serpuloBlocks=new Seq<>();
	public static Seq<SimplifiedTechNode> erekirBlocks=new Seq<>();
	public static Seq<SimplifiedTechNode> allBlocks=new Seq<>();

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
		pyratiteSmelter = new GenericCrafter("pyratite-smelter")
		{{
			localizedName="Pyratite Smelter";
			description="Use silicon directly to create pyratites";
			requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
			craftEffect = Fx.smeltsmoke;
			outputItem = new ItemStack(Items.pyratite, 1);
			size = 2;
			hasPower = true;
			hasItems=true;
			hasLiquids = false;
			drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
			ambientSound = Sounds.smelter;
			ambientSoundVolume = 0.07f;

			consumeItems(with(Items.silicon, 1, Items.lead, 2));
			consumePower(0.50f);
			serpuloBlocks.add(new SimplifiedTechNode(Blocks.pyratiteMixer,this,0));
			allBlocks.add(new SimplifiedTechNode(Blocks.pyratiteMixer,this,0));
		}};
		chemicalPlant =new RP620MultiCrafter("chemical-plant")
		{{
			requirements(Category.crafting,with(Items.graphite,100,Items.silicon,100, Items.thorium,100));
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
			serpuloBlocks.add(new SimplifiedTechNode(pyratiteSmelter,this,1));
			erekirBlocks.add(new SimplifiedTechNode(Blocks.siliconArcFurnace,this,0));
			allBlocks.add(new SimplifiedTechNode(pyratiteSmelter,this,1));
		}};


		cryogenicFreezer=new MultiCrafter("cryogenic-freezer")
		{{
			requirements(Category.crafting,with(Items.silicon,100,Items.plastanium,100));
			localizedName="Cryogenic Freezer";
			description="Use Cryofliud to cryogenic freeze any liquid";
			size=2;
			itemCapacity=10;
			liquidCapacity=10f;
			hasItems=true;
			health=300;
			craftEffect=new MultiEffect(Fx.freezing);
			//region Recipies
			resolvedRecipes=Seq.with
									   (
											   new Recipe
													   (
															   new IOEntry
																	   (
																			   Seq.with(),
																			   Seq.with(LiquidStack.with
																										   (
																												   Liquids.water,1,	//1 = 60
																												   Liquids.cryofluid,.2f
																										   )
																			   ),
																			   2		//1 = 60 Power
																	   ),
															   new IOEntry
																	   (
																			   Seq.with(ItemStack.with(RP620Items.ice,1)),
																			   Seq.with()
																	   ),
															   60		//60 = 1s
													   ),
											   new Recipe
													   (
															   new IOEntry
																	   (
																			   Seq.with(),
																			   Seq.with(LiquidStack.with
																										   (
																												   Liquids.slag,1,
																												   Liquids.cryofluid,.2f
																										   )),
																			   2
																	   ),
															   new IOEntry
																	   (
																			   Seq.with(ItemStack.with(RP620Items.sludge,1)),
																			   Seq.with()
																	   ),
															   60
													   ),
											   new Recipe
													   (
															   new IOEntry
																	   (
																			   Seq.with(),
																			   Seq.with(LiquidStack.with(Liquids.cryofluid,1.2f)),
																			   2
																	   ),
															   new IOEntry
																	   (
																			   Seq.with(ItemStack.with(RP620Items.cryocube,1)),
																			   Seq.with()
																	   ),
															   60
													   ),
											   new Recipe
													   (
															   new IOEntry
																	   (
																			   Seq.with(),
																			   Seq.with(LiquidStack.with
																										   (
																												   Liquids.oil,1,
																												   Liquids.cryofluid,.2f
																										   )),
																			   2
																	   ),
															   new IOEntry
																	   (
																			   Seq.with(ItemStack.with(RP620Items.wax,1)),
																			   Seq.with()
																	   ),
															   60
													   ),
											   new Recipe
													   (
															   new IOEntry
																	   (
																			   Seq.with(),
																			   Seq.with(LiquidStack.with
																										   (
																												   Liquids.arkycite,1,
																												   Liquids.cryofluid,.2f
																										   )),
																			   2
																	   ),
															   new IOEntry
																	   (
																			   Seq.with(ItemStack.with(RP620Items.arkyciteIce,1)),
																			   Seq.with()
																	   ),
															   60
													   ),
											   new Recipe
													   (
															   new IOEntry
																	   (
																			   Seq.with(),
																			   Seq.with(LiquidStack.with
																										   (
																												   Liquids.neoplasm,1,
																												   Liquids.cryofluid,.2f
																										   )),
																			   2
																	   ),
															   new IOEntry
																	   (
																			   Seq.with(ItemStack.with(RP620Items.neoplasmIce,1)),
																			   Seq.with()
																	   ),
															   60
													   )
									   );
			//endregion
			drawer = new DrawMulti(
					new DrawDefault(),
					new DrawFlame(),
					new DrawRecipe());
			serpuloBlocks.add(new SimplifiedTechNode(chemicalPlant,this,2));
			allBlocks.add(new SimplifiedTechNode(chemicalPlant,this,2));
		}};
		hyperThawer=new MultiCrafter("hyper-thawer")
		{{
			requirements(Category.crafting,with(Items.silicon,100,Items.plastanium,100));
			localizedName="Hyper Thawer";
			description="Use Slag to thaw most of the stuff";
			size=2;
			itemCapacity=10;
			liquidCapacity=10f;
			hasItems=true;
			health=300;
			craftEffect=new MultiEffect(Fx.burning);
			//region Recipies
			resolvedRecipes=Seq.with
									   (
											   new Recipe
													   (
															   new IOEntry
																	   (
																			   Seq.with(ItemStack.with(RP620Items.ice,1)),
																			   Seq.with(LiquidStack.with(Liquids.slag,.2f)),
																			   2		//1 = 60 Power
																	   ),
															   new IOEntry
																	   (
																			   Seq.with(),
																			   Seq.with(LiquidStack.with(Liquids.water,1))
																	   ),
															   60		//60 = 1s
													   ),
											   new Recipe
													   (
															   new IOEntry
																	   (
																			   Seq.with(ItemStack.with(RP620Items.sludge,1)),
																			   Seq.with(LiquidStack.with(Liquids.slag,.2f)),
																			   2
																	   ),
															   new IOEntry
																	   (
																			   Seq.with(),
																			   Seq.with(LiquidStack.with(Liquids.slag,1))
																	   ),
															   60
													   ),
											   new Recipe
													   (
															   new IOEntry
																	   (
																			   Seq.with(ItemStack.with(RP620Items.cryocube,1)),
																			   Seq.with(LiquidStack.with(Liquids.slag,.2f)),
																			   2
																	   ),
															   new IOEntry
																	   (
																			   Seq.with(),
																			   Seq.with(LiquidStack.with(Liquids.cryofluid,1))
																	   ),
															   60
													   ),
											   new Recipe
													   (
															   new IOEntry
																	   (
																			   Seq.with(ItemStack.with(RP620Items.wax,1)),
																			   Seq.with(LiquidStack.with(Liquids.slag,.2f)),
																			   2
																	   ),
															   new IOEntry
																	   (
																			   Seq.with(),
																			   Seq.with(LiquidStack.with(Liquids.oil,1))
																	   ),
															   60
													   ),
											   new Recipe
													   (
															   new IOEntry
																	   (
																			   Seq.with(ItemStack.with(RP620Items.arkyciteIce,1)),
																			   Seq.with(LiquidStack.with(Liquids.slag,.2f)),
																			   2
																	   ),
															   new IOEntry
																	   (
																			   Seq.with(ItemStack.with()),
																			   Seq.with(LiquidStack.with(Liquids.arkycite,1))
																	   ),
															   60
													   ),
											   new Recipe
													   (
															   new IOEntry
																	   (
																			   Seq.with(ItemStack.with(RP620Items.neoplasmIce,1)),
																			   Seq.with(LiquidStack.with(Liquids.slag,.2f)),
																			   2
																	   ),
															   new IOEntry
																	   (
																			   Seq.with(ItemStack.with()),
																			   Seq.with(LiquidStack.with(Liquids.neoplasm,1))
																	   ),
															   60
													   )
									   );
			//endregion
			drawer = new DrawMulti(
					new DrawDefault(),
					new DrawFlame(),
					new DrawRecipe());
			serpuloBlocks.add(new SimplifiedTechNode(cryogenicFreezer,this,3));
			allBlocks.add(new SimplifiedTechNode(cryogenicFreezer,this,3));
		}};
		//endregion
	}
}
