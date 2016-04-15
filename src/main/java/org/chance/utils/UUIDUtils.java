package org.chance.utils;

import java.nio.ByteBuffer;
import java.util.Random;
import java.util.UUID;

//import org.apache.commons.codec.binary.Base64;

public abstract class UUIDUtils {
	
    public static String uuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
 
//    public static String base64Uuid() {
//        UUID uuid = UUID.randomUUID();
//        return base64Uuid(uuid);
//    }
 
//    protected static String base64Uuid(UUID uuid) {
//
//        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
//        bb.putLong(uuid.getMostSignificantBits());
//        bb.putLong(uuid.getLeastSignificantBits());
//
//        return Base64.encodeBase64URLSafeString(bb.array());
//    }
 
//    public static String encodeBase64Uuid(String uuidString) {
//        UUID uuid = UUID.fromString(uuidString);
//        return base64Uuid(uuid);
//    }
 
//    public static String decodeBase64Uuid(String compressedUuid) {
//
//        byte[] byUuid = Base64.decodeBase64(compressedUuid);
//
//        ByteBuffer bb = ByteBuffer.wrap(byUuid);
//        UUID uuid = new UUID(bb.getLong(), bb.getLong());
//        return uuid.toString();
//    }
 
    public static String base58Uuid() {
        UUID uuid = UUID.randomUUID();
        return base58Uuid(uuid);
    }
 
    protected static String base58Uuid(UUID uuid) {
 
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
 
        return Base58.encode(bb.array());
    }
 
    public static String encodeBase58Uuid(String uuidString) {
        UUID uuid = UUID.fromString(uuidString);
        return base58Uuid(uuid);
    }
 
    public static String decodeBase58Uuid(String base58uuid) {
        byte[] byUuid = Base58.decode(base58uuid);
        ByteBuffer bb = ByteBuffer.wrap(byUuid);
        UUID uuid = new UUID(bb.getLong(), bb.getLong());
        return uuid.toString();
    }
    

	private static Random rand;
	
	public static String getUUID() {
		String str = UUID.randomUUID().toString();
		return str.substring(0, 8) + str.substring(9, 13)
				+ str.substring(14, 18) + str.substring(19, 23)
				+ str.substring(24);
	}
	
//	public static void main(String[]args){
//		for(int i=0;i<7;i++){
//			System.out.println(getUUID());
//		}
//
//		for(int i=0;i<7;i++){
//			System.out.println(base58Uuid());
//		}
//
//	}
}
