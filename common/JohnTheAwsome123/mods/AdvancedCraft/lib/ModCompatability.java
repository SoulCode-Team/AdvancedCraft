package JohnTheAwsome123.mods.AdvancedCraft.lib;

import cpw.mods.fml.common.Loader;

public class ModCompatability
{

    public static boolean isBuildCraftLoaded()
    {
        return Loader.isModLoaded("BuildCraft|Core");
    }
    
    public static boolean isGregTechLoaded()
    {
        return Loader.isModLoaded("gregtech_addon");
    }

    public static boolean isBasicComponentsLoaded()
    {
        return Loader.isModLoaded("BasicComponents");
    }

    public static boolean isIndustrialCraftLoaded()
    {
        return Loader.isModLoaded("IC2");
    }

    public static boolean isThaumCraftLoaded()
    {
        return Loader.isModLoaded("Thaumcraft");
    }

    public static boolean isThermalExpansionLoaded()
    {
        return Loader.isModLoaded("ThermalExpansion");
    }

    public static boolean isGalacticraftLoaded()
    {
        return Loader.isModLoaded("GalacticraftCore");
    }

    public static boolean isForestryLoaded()
    {
        return Loader.isModLoaded("Forestry");
    }

    public static boolean isOmniToolsLoaded()
    {
        return Loader.isModLoaded("OmniTools");
    }

    private static boolean isAtomicScienceLoaded()
    {
        return Loader.isModLoaded("AtomicScience");
    }

}
