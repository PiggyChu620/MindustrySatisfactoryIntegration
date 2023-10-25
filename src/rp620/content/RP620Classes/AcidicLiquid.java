package rp620.content.RP620Classes;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Geometry;
import arc.math.geom.Point2;
import arc.util.Time;
import mindustry.Vars;
import mindustry.content.Bullets;
import mindustry.entities.Fires;
import mindustry.entities.Puddles;
import mindustry.game.Team;
import mindustry.gen.Puddle;
import mindustry.type.CellLiquid;
import mindustry.type.Liquid;
import mindustry.world.Tile;

import static mindustry.entities.Puddles.maxLiquid;

public class AcidicLiquid extends CellLiquid
{
    public AcidicLiquid(String name)
    {
        super(name);
    }
    public AcidicLiquid(String name, Color color)
    {
        super(name, color);
    }
    @Override
    public void update(Puddle puddle){
        if(!Vars.state.rules.fire) return;

        float scaling = Mathf.clamp(puddle.amount / maxLiquid);


            //damage thing it is on
        if(spreadDamage > 0)
        {
            float amountSpread = Math.min(spreadConversion, maxSpread * Time.delta) / 2f;
            for(Point2 dir : Geometry.d4)
            {
                Tile other = puddle.tile.nearby(dir);
                if(other != null)
                {
                    Puddles.deposit(puddle.tile, other, puddle.liquid, amountSpread);
                    float explosive= totalExplosive(other);
                    if(explosive>0)
                    {
                        Fires.create(other);
                        Bullets.fireball.createNet(Team.derelict, other.x, other.y, Mathf.random(360f), -explosive*amountSpread, 1f, 1f);
                    }
                }
            }
            if(puddle.tile.build != null) puddle.tile.build.damage(spreadDamage * Time.delta * scaling);
        }
    }

    @Override
    public float react(Liquid other, float amount, Tile tile, float x, float y)
    {
        return amount;
    }
    private float totalExplosive(Tile tile)
    {
        float explosive=0;

        if(tile.floor().liquidDrop!=null) explosive+= tile.floor().liquidDrop.explosiveness;
        if(tile.block().hasItems) explosive+= tile.build.items.sum((i,n)->i.explosiveness*n);
        if(tile.block().hasLiquids) explosive+= tile.build.liquids.sum((l,n)->l.explosiveness*n);

        return explosive;
    }
}
