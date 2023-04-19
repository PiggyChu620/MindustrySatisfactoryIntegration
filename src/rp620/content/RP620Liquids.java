package rp620.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.effect.MultiEffect;
import mindustry.type.Liquid;
import rp620.content.RP620Classes.RP620Vars;
import rp620.content.RP620Classes.SimplifiedTechNode;
import static rp620.content.RP620Classes.RP620Vars.*;

public class RP620Liquids
{//₀₁₂₃₄₅₆₇₈₉ₓ
    public static Liquid nitrogenOxide,nitrogenDioxide,ammonia,glycerin,nitricAcid,nitroglycerin,hydrazine;


    public static void load()
    {
        nitrogenOxide=new Liquid("nitrogen-oxide", Color.valueOf("0077be"))
        {{
            localizedName="Nitrogen Oxide";
            gas=true;
            alwaysUnlocked=true;
           //TBD
            erekirContents.add(new SimplifiedTechNode(Liquids.nitrogen, this, 0));
            allContents.add(new SimplifiedTechNode(Liquids.nitrogen,this,0));
        }};
        nitrogenDioxide=new Liquid("nitrogen-dioxide", Color.valueOf("A52A2A"))
        {{
            localizedName="Nitrogen Dioxide";
            gas=true;
            heatCapacity=0;
            coolant=false;
            boilPoint=0;
            alwaysUnlocked=true;
            erekirContents.add(new SimplifiedTechNode(Liquids.nitrogen,this,0));
            allContents.add(new SimplifiedTechNode(Liquids.nitrogen,this,0));
        }};
        ammonia=new Liquid("ammonia", Color.valueOf("0073CF"))
        {{
            localizedName="Ammonia";
            gas=true;
            alwaysUnlocked=true;
            //TBD
            erekirContents.add(new SimplifiedTechNode(Liquids.nitrogen,this,0));
            allContents.add(new SimplifiedTechNode(Liquids.nitrogen,this,0));
        }};
        glycerin=new Liquid("glycerin",Color.valueOf("66CCCC"))
        {{
            localizedName="Glycerin";
            viscosity=0.75f;
            explosiveness=0.75f;
            coolant=false;
            alwaysUnlocked=true;
            serpuloContents.add(new SimplifiedTechNode(RP620Items.lye,this,2));
            allContents.add(new SimplifiedTechNode(RP620Items.lye,this,2));
        }};
        nitricAcid=new Liquid("nitric-acid",Color.valueOf("ffff00"))
        {{
            localizedName="Nitric Acid";
            heatCapacity=0.14f;
            viscosity=0.6f;
            coolant=false;
            alwaysUnlocked=true;
            erekirContents.add(new SimplifiedTechNode(Liquids.ozone,this,0));
            allContents.add(new SimplifiedTechNode(Liquids.ozone,this,0));
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
            alwaysUnlocked=true;
            allContents.add(new SimplifiedTechNode(glycerin,this,3));
        }};
        hydrazine=new Liquid("hydrazine",Color.purple)
        {{
            localizedName="Hydrazine";
            flammability=5;
            explosiveness=.5f;
            alwaysUnlocked=true;
            erekirContents.add(new SimplifiedTechNode(ammonia,this,1));
            allContents.add(new SimplifiedTechNode(ammonia,this,1));
        }};
    }
    public static void postProcess()
    {

    }
}
