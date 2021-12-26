package com.flab.nsv.system.authentication;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.springframework.stereotype.Service;

@Service
public class SHA256EncryptService implements EncryptService {

	public String encrypt(String original) {

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] encoders = md.digest(original.getBytes(StandardCharsets.UTF_8));

			StringBuilder sb = new StringBuilder();
			for (byte encoder : encoders) {
				sb.append(Integer.toString((encoder & 0xff) + 0x100, 16).substring(1));
			}

			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}