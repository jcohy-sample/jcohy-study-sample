//package com.jcohy.sample.java.jdk15;
//
//import java.math.BigInteger;
//import java.security.InvalidKeyException;
//import java.security.KeyFactory;
//import java.security.KeyPair;
//import java.security.KeyPairGenerator;
//import java.security.NoSuchAlgorithmException;
//import java.security.PublicKey;
//import java.security.Signature;
//import java.security.SignatureException;
//import java.security.spec.EdECPublicKeySpec;
//import java.security.spec.InvalidKeySpecException;
//import java.security.spec.NamedParameterSpec;
//
///**
// * Copyright: Copyright (c) 2020 <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
// *
// * <p> Description:
// *
// * @author jiac
// * @version 1.0.0 2020/10/15:15:48
// * @since 1.0.0
// */
//public class EddsaDemo {
//
//	public static String msg = "Hello World";
//
//	public static void main(String[] args) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, InvalidKeySpecException {
//		// example: generate a key pair and sign
//		KeyPairGenerator kpg = KeyPairGenerator.getInstance("Ed25519");
//		KeyPair kp = kpg.generateKeyPair();
//		// algorithm is pure Ed25519
//		Signature sig = Signature.getInstance("Ed25519");
//		sig.initSign(kp.getPrivate());
//		sig.update(msg.getBytes());
//		byte[] s = sig.sign();
//
////		System.out.println(s.toString());
////		// example: use KeyFactory to contruct a public key
////		KeyFactory kf = KeyFactory.getInstance("EdDSA");
////		boolean xOdd = true;
////		BigInteger y = new BigInteger(2L);
////		NamedParameterSpec paramSpec = new NamedParameterSpec("Ed25519");
////		EdECPublicKeySpec pubSpec = new EdECPublicKeySpec(paramSpec, new EdPoint(xOdd, y));
////		PublicKey pubKey = kf.generatePublic(pubSpec);
//	}
//}
