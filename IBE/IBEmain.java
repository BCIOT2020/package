package IBE;

import it.unisa.dia.gas.jpbc.Element;

import java.math.BigInteger;

public class IBEmain {
    public static void main(String[] args) {
        BBGHIBE bbghibe = new BBGHIBE();
        String[] testI1 = {"Depth 1"};
        String testI2 = "Depth 2";
        String testI3 = "Depth 3";
        String testI4 = "Depth 4";
        String testI5 = "Depth 5";
        String testI6 = "Depth 6";
        String testI7 = "Depth 7";
        String[] receiver = new String[7];
        receiver[0] = testI1[0];
        receiver[1] = testI2;
        receiver[2] = testI3;
        receiver[3] = testI4;
        receiver[4] = testI5;
        receiver[5] = testI6;
        receiver[6] = testI7;
        String[] ciphertextIV = new String[7];

        BBGHIBEMasterKey msk = bbghibe.Setup("a.properties", 7);
        BBGHIBESecretKey SKDepth1 = bbghibe.KeyGen(msk, testI1);
        BBGHIBESecretKey SKDepth2 = bbghibe.Delegate(SKDepth1, testI2);
        BBGHIBESecretKey SKDepth3 = bbghibe.Delegate(SKDepth2, testI3);
        BBGHIBESecretKey SKDepth4 = bbghibe.Delegate(SKDepth3, testI4);
        BBGHIBESecretKey SKDepth5 = bbghibe.Delegate(SKDepth4, testI5);
        BBGHIBESecretKey SKDepth6 = bbghibe.Delegate(SKDepth5, testI6);
        BBGHIBESecretKey SKDepth7 = bbghibe.Delegate(SKDepth6, testI7);

        BBGHIBECiphertext cf = bbghibe.Encrypt(receiver, "chenfei");
        Element decrypt = bbghibe.decrypt(receiver, cf, SKDepth1);
        BigInteger bigInteger = decrypt.toBigInteger();
        String s = bbghibe.numberToLetter(bigInteger);
        System.out.println(bbghibe.PrivateKey);
        System.out.println(bbghibe.PublicKey);
        System.out.println(s);

    }
}
