package com.controllers;

import com.InterfaceGraphique.FrameImage;
import com.InterfaceGraphique.PaysSelection;

import java.util.Observable;
import java.util.Observer;

/**
 * <h1>com.controllers FramesImagesController</h1>
 *
 * @author Erwan LBP
 * @version 1.0
 * @since 27-12-2016
 */
public class FramesImagesController implements Observer {

    private PaysSelection paysSelection;
    private FrameImage frameDrapeau;
    private FrameImage frameMap;
    private FrameImage frameLocator;

    public FramesImagesController(PaysSelection paysSelection, FrameImage frameDrapeau, FrameImage frameMap, FrameImage frameLocator) {
        this.paysSelection = paysSelection;
        this.frameDrapeau = frameDrapeau;
        this.frameMap = frameMap;
        this.frameLocator = frameLocator;
    }

    @Override
    public void update(Observable observable, Object o) {
        frameDrapeau.actualize(paysSelection.getPays().getPathToflag(), "Drapeau " + paysSelection.getPays().getFrName());
        frameMap.actualize(paysSelection.getPays().getPathToMap(), "Carte" + paysSelection.getPays().getFrName());
        frameLocator.actualize(paysSelection.getPays().getPathToLocator(), "Carte Région " + paysSelection.getPays().getPathToLocator());
    }
}

