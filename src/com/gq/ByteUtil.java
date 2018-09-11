package com.gq;

/**
 * @author gq
 * @version 1.0, 2018-07-16
 */

public class ByteUtil {
    //将长度为len的sec数组添加到fir数组firOffset处
    public static byte[] byteArrayWrite(byte[] fir,
                                         byte[] sec,
                                         int firOffset,
                                         int length) throws IndexOutOfBoundsException{
        for (int i = 0; i < length; i++) {
            fir[firOffset + i] = sec[i];
        }

        return fir;
    }
    //将byte添加到fir数组firOffset处
    public static byte[] byteArrayWrite(byte[] fir,
                                        byte sec,
                                        int firOffset) throws IndexOutOfBoundsException{
        fir[firOffset] = sec;
        return fir;
    }
    //将sec中firOffset处开始长度为len的数组复制到fir中
    public static byte[] byteArrayRead(byte[] fir,
                                        byte[] sec,
                                        int secOffset,
                                        int length) throws IndexOutOfBoundsException{
        for (int i = 0; i < length; i++)
            fir[i] = sec[secOffset + i];

        return fir;
    }
    //将两个数组合并
    public static byte[] byteArrayCombine(byte[] fir,
                                           int firLen,
                                           byte[] sec,
                                           int secLen) throws IndexOutOfBoundsException{
        byte[] result = new byte[firLen + secLen];
        for (int i = 0; i < firLen; i++)
            result[i] = fir[i];
        for (int i = 0; i < secLen; i++)
            result[firLen + i] = sec[i];
        return result;
    }
    //获取数组从偏移点offset长len的子数组
    public static byte[] getSubByteArray(byte[] byteArray,
                                          int offset,
                                          int len) throws IndexOutOfBoundsException{
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++)
            result[i] = byteArray[offset + i];
        return result;
    }
    //int, float与byte类型间的转换
    public static byte[] intToByte(int i){
        byte[] iByte = new byte[4];
        for (int j = 0; j < 4; j++)
            iByte[j] = (byte)((i>>j*8)&0xff);
        return iByte;
    }

    public static int byteToInt(byte[] b){
        int i = 0;
        for (int j = 0; j < 4; j++)
            i += ((b[j]&0xff)<<j*8);
        return i;
    }

    public static byte[] floatToByte(float f){
        int fInt = Float.floatToIntBits(f);
        byte[] fByte = new byte[4];
        for (int j = 0; j < 4; j++)
            fByte[j] = (byte)(fInt >> (24 - j * 8));
        byte[] dest = new byte[4];
        System.arraycopy(fByte, 0, dest, 0, 4);
        byte temp;
        for (int j = 0; j < 2; j++){
            temp = dest[j];
            dest[j] = dest[3 - j];
            dest[3 - j] = temp;
        }
        return dest;
    }

    public static float byteToFloat(byte[] b){
        int fInt = 0;
        for (int j = 0; j < 4; j++)
            fInt += ((b[j]&0xff) << j * 8);
        return Float.intBitsToFloat(fInt);
    }

    public static String byteToString(byte[] b){
        int len = 0;
        for (int i = 0; i < b.length; i++){
            if (b[i] == 0) {
                len = i;
                break;
            }
        }
        return new String(b, 0, len);
    }

    public static boolean byteToBoolean(byte b){
        return b != 0;
    }

    public static byte booleanToByte(boolean b){
        return (byte)(b ? 1 : 0);
    }
}
