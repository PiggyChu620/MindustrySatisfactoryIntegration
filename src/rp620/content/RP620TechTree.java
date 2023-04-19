package rp620.content;

import arc.struct.ObjectMap;
import arc.struct.Seq;
import arc.util.Log;
import mindustry.content.Planets;
import mindustry.content.SerpuloTechTree;
import mindustry.content.TechTree;
import mindustry.ctype.ContentType;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives;
import mindustry.type.ItemStack;
import mindustry.type.Planet;
import rp620.content.RP620Classes.SimplifiedTechNode;
import static rp620.content.RP620Classes.RP620Vars.*;

public class RP620TechTree extends TechTree
{
    static TechTree.TechNode context;
    static Planet curPlanet;
    public static void postProcess()
    {
        Planets.serpulo.techTree.each(t->t.planet=Planets.serpulo);
        Planets.erekir.techTree.each(t->t.planet=Planets.erekir);
        for(SimplifiedTechNode stn:serpuloContents.sort(x->x.priority))
        {
            mergeNode(stn.parent,()->{nodeProduce(stn.content,()->{});},Planets.serpulo);
        }
        for(SimplifiedTechNode stn:erekirContents.sort(x->x.priority))
        {
            mergeNode(stn.parent,()->{nodeProduce(stn.content,()->{});},Planets.erekir);
        }
        for(SimplifiedTechNode stn:allContents.sort(x->x.priority))
        {
            mergeNode(stn.parent,()->{nodeProduce(stn.content,()->{});},null);
        }
        for(SimplifiedTechNode stn:RP620Blocks.serpuloBlocks.sort(x->x.priority))
        {
            mergeNode(stn.parent,()->{node(stn.content,()->{});},Planets.serpulo);
        }
        for(SimplifiedTechNode stn:RP620Blocks.erekirBlocks.sort(x->x.priority))
        {
            mergeNode(stn.parent,()->{node(stn.content,()->{});},Planets.erekir);
        }
        for(SimplifiedTechNode stn:RP620Blocks.allBlocks.sort(x->x.priority))
        {
            mergeNode(stn.parent,()->{node(stn.content,()->{});},null);
        }
    }
    private static void mergeNode(UnlockableContent parent, Runnable children, Planet planet)
    {
        Seq<TechNode> contents;

        curPlanet=planet;
        if(planet!=null) contents=all.select(t -> t.content == parent && t.planet==planet);
        else contents=all.select(t -> t.content == parent && t.planet!=Planets.serpulo && t.planet!=Planets.erekir);


        for(TechTree.TechNode tn : contents)
        {
            context=tn;
            children.run();
        }
    }
    /*private static void mergeNode(UnlockableContent parent, Runnable children)
    {
        context = (TechTree.TechNode)TechTree.all.find((t) -> {
            return t.content == parent;
        });
        children.run();
    }
    private static void node(UnlockableContent content, ItemStack[] requirements, Seq<Objectives.Objective> objectives, Runnable children) {
        TechTree.TechNode node = new TechTree.TechNode(context, content, requirements);
        if (objectives != null) {
            node.objectives = objectives;
        }

        TechTree.TechNode prev = context;
        context = node;
        children.run();
        context = prev;
    }

    private static void node(UnlockableContent content, ItemStack[] requirements, Runnable children) {
        node(content, requirements, (Seq)null, children);
    }

    private static void node(UnlockableContent content, Seq<Objectives.Objective> objectives, Runnable children) {
        node(content, content.researchRequirements(), objectives, children);
    }

    private static void node(UnlockableContent content, Runnable children) {
        node(content, content.researchRequirements(), children);
    }

    private static void node(UnlockableContent block) {
        node(block, () -> {
        });
    }*/
    public static TechTree.TechNode nodeRoot(String name, UnlockableContent content, Runnable children){
        return nodeRoot(name, content, false, children);
    }

    public static TechTree.TechNode nodeRoot(String name, UnlockableContent content, boolean requireUnlock, Runnable children){
        var root = node(content, content.researchRequirements(), children);
        root.name = name;
        root.requiresUnlock = requireUnlock;
        roots.add(root);
        return root;
    }

    public static TechTree.TechNode node(UnlockableContent content, Runnable children){
        return node(content, content.researchRequirements(), children);
    }

    public static TechTree.TechNode node(UnlockableContent content, ItemStack[] requirements, Runnable children){
        return node(content, requirements, null, children);
    }

    public static TechTree.TechNode node(UnlockableContent content, ItemStack[] requirements, Seq<Objectives.Objective> objectives, Runnable children){
        TechTree.TechNode node = new TechTree.TechNode(context, content, requirements);
        if(objectives != null){
            node.objectives.addAll(objectives);
        }
        if(curPlanet!=null) node.planet=curPlanet;
        TechTree.TechNode prev = context;
        context = node;
        children.run();
        context = prev;

        return node;
    }

    public static TechTree.TechNode node(UnlockableContent content, Seq<Objectives.Objective> objectives, Runnable children){
        return node(content, content.researchRequirements(), objectives, children);
    }

    public static TechTree.TechNode node(UnlockableContent block){
        return node(block, () -> {});
    }

    public static TechTree.TechNode nodeProduce(UnlockableContent content, Seq<Objectives.Objective> objectives, Runnable children){
        return node(content, content.researchRequirements(), objectives.add(new Objectives.Produce(content)), children);
    }

    public static TechTree.TechNode nodeProduce(UnlockableContent content, Runnable children){
        return nodeProduce(content, new Seq<>(), children);
    }
}
