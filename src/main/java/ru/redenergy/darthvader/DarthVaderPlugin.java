package ru.redenergy.darthvader;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

public class DarthVaderPlugin implements IFMLLoadingPlugin {

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"ru.redenergy.darthvader.DarthVaderClassTransformer"};
    }

    @Override
    public String getModContainerClass() {
        return "ru.redenergy.darthvader.DarthVaderMod";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {}

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
