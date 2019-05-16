package org.milan.core.networking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Calculate MD5, SHA1 and SHA256 of a input string
 *
 * @author Milan Rathod
 */
public class HashCalculation {

    private static final Logger LOG = LoggerFactory.getLogger(HashCalculation.class);

    public String getHash(String input, String hashType) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(hashType);

            byte[] digest = messageDigest.digest(input.getBytes());

            BigInteger bigInteger = new BigInteger(1, digest);

            StringBuilder hashText = new StringBuilder(bigInteger.toString(16));

            while (hashText.length() < 32) {
                hashText.insert(0, "0");
            }
            return hashText.toString();
        } catch (NoSuchAlgorithmException e) {
            LOG.error("No Algorithm of type {} exists", hashType);
            return null;
        }
    }
}
