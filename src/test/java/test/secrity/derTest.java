package test.secrity;

import org.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.Signature;
import java.security.cert.X509Certificate;


/**
 * @ProjectName: vz-bankorg-model
 * @Package: test.secrity
 * @ClassName: derTest
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/26 15:16
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/26 15:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class derTest {

    public static void main(String[] args) throws Exception {

        // 证书串，通常通过读取证书文件获取到，这里是一张SM2证书。
        String certStr = "MIID0TCCA3WgAwIBAgIIAwAAAAA8UqcwDAYIKoEcz1UBg3UFADBYMQswCQYDVQQG\n" +
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

// 签名原文
        String plaintext = "signdata";

// 签名产生签名值，此处的签名值实际上就是 R和S的sequence
        String signValueStr = "MIID0TCCA3WgAwIBAgIIAwAAAAA8UqcwDAYIKoEcz1UBg3UFADBYMQswCQYDVQQG\n" +
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
        byte[] signValue = Base64.decode(signValueStr);
        /*
         * 解析证书
         */
        CertificateFactory factory = new CertificateFactory();
        X509Certificate certificate =
                (X509Certificate) factory
                        .engineGenerateCertificate(new ByteArrayInputStream(Base64.decode(certStr)));

        System.out.println(certificate.getSigAlgName());

        // 验证签名
        Signature signature = Signature.getInstance(certificate.getSigAlgName(), new BouncyCastleProvider());
        signature.initVerify(certificate);
        signature.update(plaintext.getBytes(StandardCharsets.UTF_8));

        System.out.println(signature.verify(signValue));

    }

}
