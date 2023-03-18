package com.fj.generate.utils;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.Blob;

/**
 * <p>
 * 序列化工具包
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/16 16:04
 */
public class SerializeUtil {
    private static ByteArrayInputStream byteArrayInputStream = null;
    private static ByteArrayOutputStream byteArrayOutputStream = null;
    private static ObjectInputStream objectInputStream = null;
    private static ObjectOutputStream objectOutputStream = null;

    public SerializeUtil() {
    }

    public static byte[] serializeObjectToByteArray(Object object) {
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            try {
                releaseStream();
            } catch (Exception var9) {
                var9.printStackTrace();
            }

        }

        return byteArrayOutputStream.toByteArray();
    }

    public static Blob serializeObjectToBlob(Object object) {
        Blob blobObject = null;

        try {
            byte[] b = serializeObjectToByteArray(object);
            blobObject = new SerialBlob(b);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return blobObject;
    }

    public static byte[] serializeBlobToByteArray(Blob blob) {
        byte[] bytes = null;

        try {
            bytes = blob.getBytes(1L, (int)blob.length());
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return bytes;
    }

    public static Object deserializeObject(byte[] buf) {
        Object object = null;

        try {
            byteArrayInputStream = new ByteArrayInputStream(buf);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            object = objectInputStream.readObject();
        } catch (Exception var11) {
            var11.printStackTrace();
        } finally {
            try {
                releaseStream();
            } catch (Exception var10) {
                var10.printStackTrace();
            }

        }

        return object;
    }

    public static Object deserializeObject(InputStream is) {
        Object object = null;

        try {
            byte[] bytes = getByteArrayFromStream(is);
            object = deserializeObject(bytes);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return object;
    }

    public static byte[] getByteArrayFromStream(InputStream is) {
        Object object = null;
        byte[] bytes = null;

        try {
            bytes = new byte[is.available()];
            int offset = 0;

            for(int numRead; offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0; offset += numRead) {
            }

            is.close();
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return bytes;
    }

    public static <T> T deepClone(T t) {
        Object object = null;
        T target = null;
        byteArrayInputStream = null;
        objectInputStream = null;
        if (t != null) {
            try {
                byteArrayInputStream = new ByteArrayInputStream(serializeObjectToByteArray(t));
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                object = objectInputStream.readObject();
                target = (T) object;
            } catch (Exception var12) {
                var12.printStackTrace();
            } finally {
                try {
                    releaseStream();
                } catch (Exception var11) {
                    var11.printStackTrace();
                }

            }
        }

        return target;
    }

    private static void releaseStream() throws IOException {
        if (null != byteArrayInputStream) {
            byteArrayInputStream.close();
        }

        if (null != byteArrayOutputStream) {
            byteArrayOutputStream.close();
        }

        if (null != objectInputStream) {
            objectInputStream.close();
        }

        if (null != objectOutputStream) {
            objectOutputStream.close();
        }

    }
}
