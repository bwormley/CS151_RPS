/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps.player;

import cs151_rps.GameObject;

//import solomonClientLib.proxy.RemotePlayer;
import solomonserver.Gesture;
import solomonserver.ResultCode;
//import solomonserver.Scorecard;
import static solomonserver.Gesture.*;
import static solomonserver.ResultCode.*;

/**
 *
 * @author bwormley
 */
public class RemotePlayer extends Player {
    
     RemotePlayer() { 
         super(null,null); 
         this.name = "REMOTE";
     }

    @Override
    public GameObject queryThrow() throws Exception {
        solomonserver.Scorecard score = solomonClientLib.RemotePlayer.getInstance().getScore();
        switch (score.opponentGesture) {
            case ROCK:  return GameObject.ROCK;
            case PAPER: return GameObject.PAPER;
            default:    return GameObject.SCISSORS;
        }
    }
    
}
