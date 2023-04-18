package rp620.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.effect.MultiEffect;
import mindustry.type.Liquid;

public class RP620Liquids
{//₀₁₂₃₄₅₆₇₈₉ₓ
    public static Liquid nitrogenOxide,nitrogenDioxide,ammonia,glycerin,nitricAcid,nitroglycerin,hydrazine;
    public static void load()
    {
        nitrogenOxide=new Liquid("nitrogen-oxide", Color.valueOf("0077be"))
        {{
           localizedName="Nitrogen Oxide";
           gas=true;
           //TBD
        }};
        nitrogenDioxide=new Liquid("nitrogen-dioxide", Color.valueOf("A52A2A"))
        {{
            localizedName="Nitrogen Dioxide";
            gas=true;
            heatCapacity=0;
            coolant=false;
            boilPoint=0;
        }};
        ammonia=new Liquid("ammonia", Color.valueOf("0073CF"))
        {{
            localizedName="Ammonia";
            gas=true;
            //TBD
        }};
        glycerin=new Liquid("glycerin",Color.valueOf("66CCCC"))
        {{
            localizedName="Glycerin";
            viscosity=0.75f;
            explosiveness=0.75f;
            coolant=false;
        }};
        nitricAcid=new Liquid("nitric-acid",Color.valueOf("ffff00"))
        {{
            localizedName="Nitric Acid";
            heatCapacity=0.14f;
            viscosity=0.6f;
            coolant=false;
        }};
        nitroglycerin=new Liquid("nitroglycerin", Color.valueOf("ff3f3f"))
        {{
            localizedName="Nitroglycerin";
            temperature=0.75f;
            flammability=10;
            viscosity=.35f;
            explosiveness=1.54f;
            coolant=false;
            effect= StatusEffects.blasted;
        }};
        hydrazine=new Liquid("hydrazine",Color.purple)
        {{
            localizedName="Hydrazine";
            flammability=5;
            explosiveness=.5f;
        }};
    }
}
