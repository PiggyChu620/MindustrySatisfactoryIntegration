package rp620.content.RP620Classes;

import mindustry.ctype.UnlockableContent;

public class SimplifiedTechNode
{
    public UnlockableContent parent;
    public UnlockableContent content;
    public int priority;
    public SimplifiedTechNode(UnlockableContent p,UnlockableContent c,int pr)
    {
        parent=p;
        content=c;
        priority=pr;
    }
}
