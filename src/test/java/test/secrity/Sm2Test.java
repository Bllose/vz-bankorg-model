package test.secrity;

import com.vz.model.utils.special.security.Util;
import com.vz.model.utils.special.security.sm2.SM2EncDecUtils;
import com.vz.model.utils.special.security.sm2.SM2KeyVO;
import com.vz.model.utils.special.security.sm2.SM2SignVO;
import com.vz.model.utils.special.security.sm2.SM2SignVerUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.util.encoders.Hex;

import java.io.IOException;
import java.util.UUID;

/**
 * @ProjectName: vz-bankorg-model
 * @Package: test.secrity
 * @ClassName: Sm2Test
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/26 14:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/26 14:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Sm2Test {

    public static void main(String args[]){

        try {

            String testContent = "vzoom";
            String publicKey = "MIID0TCCA3WgAwIBAgIIAwAAAAA8UqcwDAYIKoEcz1UBg3UFADBYMQswCQYDVQQG\n" +
                    "EwJDTjEQMA4GA1UECAwHQmVpamluZzEUMBIGA1UECgwLRUNDQS5DT00uQ04xDTAL\n" +
                    "BgNVBAsMBEVDQ0ExEjAQBgNVBAMMCVNNMlJvb3RDQTAeFw0xOTA4MjMwMDAwMDBa\n" +
                    "Fw0xOTEwMjAwMDAwMDBaMIGJMQswCQYDVQQGEwJDTjESMBAGA1UECAwJ5rmW5YyX\n" +
                    "55yBMRIwEAYDVQQHDAnmrabmsYnluIIxGzAZBgNVBAoMEuatpuaxieS8l+mCpumT\n" +
                    "tuihjDEYMBYGA1UECwwP5L+h5oGv56eR5oqA6YOoMRswGQYDVQQDDBLkvJfpgqbp\n" +
                    "k7booYzmtYvor5UwWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAAQep6kJnaYLY67i\n" +
                    "IZXk1020duvEJcnZkh3AzAAXrRothfm3rVNesjlxsROal+FUGr1wf3/p7BkYZ8A4\n" +
                    "8DGLbAwso4IB8zCCAe8wDgYDVR0PAQH/BAQDAgP4MAwGA1UdEwEB/wQCMAAwEwYD\n" +
                    "VR0lBAwwCgYIKwYBBQUHAwEwHwYDVR0jBBgwFoAU/uESIo/pJd7wMDaoNrzaE03U\n" +
                    "rhAwHQYDVR0OBBYEFJlkE5OQ9A5+T6fVgyAeajzEovKZMEQGCSqGSIb3DQEJDwQ3\n" +
                    "MDUwDgYIKoZIhvcNAwICAgCAMA4GCCqGSIb3DQMEAgIAgDAHBgUrDgMCBzAKBggq\n" +
                    "hkiG9w0DBzB7BgNVHR8EdDByMHCgbqBshmpsZGFwOi8vbGRhcC5lY2NhLmNvbS5j\n" +
                    "bjozODkvY249Y3JsMDMwMDAwLG91PWNybDAwLG91PWNybCxjPWNuP2NlcnRpZmlj\n" +
                    "YXRlcmV2b2NhdGlvbmxpc3Q/c3ViPyhjbj1jcmwwMzAwMDApMDkGCCsGAQUFBwEB\n" +
                    "BC0wKzApBggrBgEFBQcwAYYdaHR0cDovL29jc3AuZWNjYS5jb20uY246ODgwMC8w\n" +
                    "IwYKKwYBBAGpQ2QFCAQVDBMwMy0wMDAxMWQzMTAxODQyMDMyMCMGCisGAQQBqUNk\n" +
                    "BQkEFQwTMDMtMDAwMTFkMzEwMTg0MjAzMjASBgorBgEEAalDZAIBBAQMAjQzMB4G\n" +
                    "CGCGSAGG+EMJBBIMEDAxMDAwNDAwMDE3MTg1MjkwDAYIKoEcz1UBg3UFAANIADBF\n" +
                    "AiEAv0c3tfCtNLeb6tYNZYCAnlfDRw/lvoZm+bTfQpPuvs8CIGGRzD7cuE4KMPqh\n" +
                    "TirF9hhEqIBD6GOacp5ZqgIWqASa";
            String qm = SM2EncDecUtils.encrypt(publicKey.getBytes(), testContent.getBytes());
            System.out.println("My qm : " + qm);

            System.out.println("--产生SM2秘钥--:");
            SM2KeyVO sm2KeyVO = generateSM2Key();
            System.out.println("公钥:" + sm2KeyVO.getPubHexInSoft());
            System.out.println("私钥:" + sm2KeyVO.getPriHexInSoft());
            //数据加密
            System.out.println("--测试加密开始--");
            String src = "I Love You";


            System.out.println("--测试SM2签名--");
            System.out.println("原文hex:" + Util.byteToHex(src.getBytes()));
            String s5 = Util.byteToHex(src.getBytes());

            System.out.println("签名测试开始:");
            SM2SignVO sign = genSM2Signature(sm2KeyVO.getPriHexInSoft(), s5);
            System.out.println("软加密签名结果:" + sign.getSm2_signForSoft());
            System.out.println("加密机签名结果:" + sign.getSm2_signForHard());
            //System.out.println("转签名测试:"+SM2SignHardToSoft(sign.getSm2_signForHard()));
            System.out.println("验签1,软件加密方式:");
            boolean b = verifySM2Signature(sm2KeyVO.getPubHexInSoft(), s5, sign.getSm2_signForSoft());
            System.out.println("软件加密方式验签结果:" + b);
            System.out.println("验签2,硬件加密方式:");
            String sm2_signForHard = sign.getSm2_signForHard();
            System.out.println("签名R:" + sign.sign_r);
            System.out.println("签名S:" + sign.sign_s);
            //System.out.println("硬:"+sm2_signForHard);
            b = verifySM2Signature(sm2KeyVO.getPubHexInSoft(), s5, SM2SignHardToSoft(sign.getSm2_signForHard()));
            System.out.println("硬件加密方式验签结果:" + b);
            if (!b) {
                throw new RuntimeException();
            }
            System.out.println("--签名测试结束--");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


//    //SM2公钥soft和Hard转换
//    public static String SM2PubKeySoftToHard(String softKey) {
//        return SM2PubHardKeyHead + softKey;
//    }
//
//    //SM2公钥Hard和soft转换
//    public static String SM2PubKeyHardToSoft(String hardKey) {
//        return hardKey.replaceFirst(SM2PubHardKeyHead, "");
//    }

    //产生非对称秘钥
    public static SM2KeyVO generateSM2Key() throws IOException {
        SM2KeyVO sm2KeyVO = SM2EncDecUtils.generateKeyPair();
        return sm2KeyVO;
    }

    //公钥加密
    public static String SM2Enc(String pubKey, String src) throws IOException {
        String encrypt = SM2EncDecUtils.encrypt(Util.hexStringToBytes(pubKey), src.getBytes());
        //删除04
        encrypt=encrypt.substring(2,encrypt.length());
        return encrypt;
    }

    //私钥解密
    public static String SM2Dec(String priKey, String encryptedData) throws IOException {
        //填充04
        encryptedData="04"+encryptedData;
        byte[] decrypt = SM2EncDecUtils.decrypt(Util.hexStringToBytes(priKey), Util.hexStringToBytes(encryptedData));
        return new String(decrypt);
    }

    //私钥签名,参数二:原串必须是hex!!!!因为是直接用于计算签名的,可能是SM3串,也可能是普通串转Hex
    public static SM2SignVO genSM2Signature(String priKey, String sourceData) throws Exception {
        SM2SignVO sign = SM2SignVerUtils.Sign2SM2(Util.hexToByte(priKey), Util.hexToByte(sourceData));
        return sign;
    }

    //公钥验签,参数二:原串必须是hex!!!!因为是直接用于计算签名的,可能是SM3串,也可能是普通串转Hex
    public static boolean verifySM2Signature(String pubKey, String sourceData, String hardSign) {
        SM2SignVO verify = SM2SignVerUtils.VerifySignSM2(Util.hexStringToBytes(pubKey), Util.hexToByte(sourceData), Util.hexToByte(hardSign));
        return verify.isVerify();
    }

    //SM2签名Hard转soft
    public static String SM2SignHardToSoft(String hardSign) {
        byte[] bytes = Util.hexToByte(hardSign);
        byte[] r = new byte[bytes.length / 2];
        byte[] s = new byte[bytes.length / 2];
        System.arraycopy(bytes, 0, r, 0, bytes.length / 2);
        System.arraycopy(bytes, bytes.length / 2, s, 0, bytes.length / 2);
        ASN1Integer d_r = new ASN1Integer(Util.byteConvertInteger(r));
        ASN1Integer d_s = new ASN1Integer(Util.byteConvertInteger(s));
        ASN1EncodableVector v2 = new ASN1EncodableVector();
        v2.add(d_r);
        v2.add(d_s);
        DERSequence sign = new DERSequence(v2);

        String result = null;
        try {
            result = Util.byteToHex(sign.getEncoded());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        //SM2加密机转软加密编码格式
        //return SM2SignHardKeyHead+hardSign.substring(0, hardSign.length()/2)+SM2SignHardKeyMid+hardSign.substring(hardSign.length()/2);
        return result;
    }

    //摘要计算
    public static String generateSM3HASH(String src) {
        byte[] md = new byte[32];
        byte[] msg1 = src.getBytes();
        //System.out.println(Util.byteToHex(msg1));
        SM3Digest sm3 = new SM3Digest();
        sm3.update(msg1, 0, msg1.length);
        sm3.doFinal(md, 0);
        String s = new String(Hex.encode(md));
        return s.toUpperCase();
    }

    //产生对称秘钥
    public static String generateSM4Key() {
        return UUID.randomUUID().toString().replace("-", "");
    }




}
