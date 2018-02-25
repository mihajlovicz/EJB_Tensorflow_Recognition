/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fileupload;

import javax.ejb.Remote;

/**
 *
 * @author Korisnik
 */
@Remote
public interface RecognitionRemote {
    float[] executeInceptionGraph();
}
