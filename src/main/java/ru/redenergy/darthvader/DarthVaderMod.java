package ru.redenergy.darthvader;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.ModMetadata;

public class DarthVaderMod extends DummyModContainer{

    public DarthVaderMod() {
        super(new ModMetadata());
        super.getMetadata().name = "Darth Vader Loader";
        super.getMetadata().modId = "darth-vader";
        super.getMetadata().authorList.add("RedEnergy");
    }

}
