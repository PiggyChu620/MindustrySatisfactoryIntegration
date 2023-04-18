package rp620.content;

import arc.Core;
import arc.func.Func;
import arc.func.Prov;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.geom.Geometry;
import arc.scene.ui.layout.Cell;
import arc.scene.ui.layout.Table;
import arc.scene.utils.Elem;
import arc.struct.Seq;
import arc.util.Log;
import arc.util.Time;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.core.UI;
import mindustry.gen.Building;
import mindustry.gen.Call;
import mindustry.gen.Tex;
import mindustry.graphics.Pal;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.ui.Bar;
import mindustry.ui.Styles;
import mindustry.world.blocks.distribution.StackConveyor;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.world.consumers.ConsumeLiquids;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;
import multicraft.MultiCrafter;
import multicraft.Recipe;
import multicraft.RecipeSelector;

import static mindustry.Vars.tilesize;
import static mindustry.Vars.world;

public class RP620MultiCrafter extends MultiCrafter
{
    public RP620MultiCrafter(String name)
    {
        super(name);
    }

    @Override
    public void init()
    {
        super.init();
        selector = RecipeSelector.get("number");

    }
    public class RP620MultiCrafterBuild extends MultiCrafterBuild
    {
//        @Override
//        public void configure(Object value)
//        {
//            this.block.lastConfig = value;
//            Call.tileConfig(Vars.player, this, value);
//        }
        @Override
        public void dumpOutputs()
        {
            Recipe curRecipe = getCurRecipe();
            if (curRecipe.isOutputItem() && timer(timerDump, dumpTime / timeScale)) for (ItemStack output : curRecipe.output.items) dump(output.item);

            if (curRecipe.isOutputFluid())
            {
                Seq<LiquidStack> fluids = curRecipe.output.fluids;
                switch(fluids.size)
                {
                    case 1:
                        dumpLiquid(fluids.get(0).liquid,2,-1);
                        //Log.info("Set up fluid size 1 output");
                        break;
                    case 2:
                        for(int i=0;i<2;i++)
                        {
                            int dir=2*i+1;
                            dumpLiquid(fluids.get(i).liquid, 2f, dir);
                        }
                        //Log.info("Set up fluid size 2 output");
                        break;
                    case 3:
                    case 4:
                        for(int i=0;i<fluids.size;i++)
                        {
                            int dir=i+1;
                            dumpLiquid(fluids.get(i).liquid, 2f, dir);
                        }
                        //Log.info("Set up fluid size "+fluids.size+" output");
                        break;
                    default:
                        for(int i=0;i<fluids.size;i++)
                        {
                            dumpLiquid(fluids.get(i).liquid,2,-1);
                        }

                        break;
                }
            }
        }
//        @Override
//        public void configure(Object value)
//        {
//            this.block.lastConfig = value;
//            Call.tileConfig(Vars.player, this, value);
//        }


    }
    @Override
    public void buildStats(Table stat)
    {
        int i=0;
        stat.row();
        for (Recipe recipe : resolvedRecipes) {
            Table t = new Table();
            t.background(Tex.whiteui);
            t.setColor(Pal.darkestGray);
            t.add(Elem.newButton(""+i++, Styles.nonet,()->{} ));
            // Input
            buildIOEntry(t, recipe, true);
            // Time
            Table time = new Table();
            final float[] duration = {0f};
            float visualCraftTime = recipe.craftTime;
            time.update(() -> {
                duration[0] += Time.delta;
                if (duration[0] > visualCraftTime) duration[0] = 0f;
            });
            String craftTime = recipe.craftTime == 0 ? "0" : String.format("%.2f", recipe.craftTime / 60f);
            Cell<Bar> barCell = time.add(new Bar(() -> craftTime,
                                                 () -> Pal.accent,
                                                 () -> Interp.smooth.apply(duration[0] / visualCraftTime)))
                                    .height(45f);
            if (Vars.mobile)
                barCell.width(220f);
            else
                barCell.width(250f);
            Cell<Table> timeCell = t.add(time).pad(12f);
            if (showNameTooltip) timeCell.tooltip(Stat.productionTime.localized() + ": " + craftTime + " " + StatUnit.seconds.localized());
            // Output
            buildIOEntry(t, recipe, false);
            stat.add(t).pad(10f).grow();
            stat.row();
        }
        stat.row();
        stat.defaults().grow();
    }
    private Recipe recipe=null;
    @Override
    public void drawOverlay(float x, float y, int rotation)
    {
        Building tile = world.buildWorld(x, y);
        if(tile==null) Log.info("Can not find Building");
        else if(tile instanceof RP620MultiCrafterBuild s)
        {
            recipe=s.getCurRecipe();
        }
        if(recipe==null) recipe=resolvedRecipes.get(0);
        setBars();
        Seq<LiquidStack> fluids = recipe.output.fluids;

        switch(fluids.size)
        {
            case 2:
                for(int i=0;i<2;i++)
                {
                    int dir=2*i+1;
                    int rot=dir + rotation;
                    String imageName= name + "-" + fluids.get(i).liquid.name + "-output" + ((rot==4 || rot==1)?0:1);

                    Log.info(imageName);
                    Draw.rect(Core.atlas.find(imageName),x,y,rot*90);
                    Draw.rect(
                            fluids.get(i).liquid.fullIcon,
                            x + Geometry.d4x(rot) * (size * tilesize / 2f + 4),
                            y + Geometry.d4y(rot) * (size * tilesize / 2f + 4),
                            8f, 8f
                    );
                }
                Log.info("Set up fluid size 2 overlay");
                break;
            case 3:
            case 4:
                for(int i=0;i<fluids.size;i++)
                {
                    int dir=i+1;
                    Draw.rect(
                            fluids.get(i).liquid.fullIcon,
                            x + Geometry.d4x(dir + rotation) * (size * tilesize / 2f + 4),
                            y + Geometry.d4y(dir + rotation) * (size * tilesize / 2f + 4),
                            8f, 8f
                    );
                }
                Log.info("Set up fluid size "+fluids.size+" overlay");
                break;
        }
    }
    @Override
    public void setBars()
    {
        if(recipe==null) super.setBars();
        else
        {
            barMap.clear();
            addBar("health", entity -> new Bar("stat.health", Pal.health, entity::healthf).blink(Color.white));

            if(consPower != null){
                boolean buffered = consPower.buffered;
                float capacity = consPower.capacity;

                addBar("power", entity -> new Bar(
                        () -> buffered ? Core.bundle.format("bar.poweramount", Float.isNaN(entity.power.status * capacity) ? "<ERROR>" : UI.formatAmount((int)(entity.power.status * capacity))) :
                                Core.bundle.get("bar.power"),
                        () -> Pal.powerBar,
                        () -> Mathf.zero(consPower.requestedPower(entity)) && entity.power.graph.getPowerProduced() + entity.power.graph.getBatteryStored() > 0f ? 1f : entity.power.status)
                );
            }
            for(ItemStack l:recipe.input.items)
            {
                addBar("item-"+l.item.name,entity->new Bar(
                        ()->l.item.localizedName,
                        ()->l.item.color,
                        ()->entity.items.get(l.item)/itemCapacity
                ));
            }
            for(LiquidStack l:recipe.input.fluids)
            {
                addLiquidBar(l.liquid);
            }
        }

        addBar("progress", (b) -> new Bar("bar.loadprogress", Pal.accent, b::progress));
        if (isConsumeHeat || isOutputHeat) addBar("heat", (MultiCrafterBuild b) -> new Bar("bar.heat", Pal.lightOrange, b::heatFrac));
    }
}
