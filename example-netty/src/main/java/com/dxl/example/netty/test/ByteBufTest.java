package com.dxl.example.netty.test;

import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

public class ByteBufTest extends AbstractByteBuf {
    protected ByteBufTest(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    protected byte _getByte(int index) {
        return 0;
    }

    @Override
    protected short _getShort(int index) {
        return 0;
    }

    @Override
    protected short _getShortLE(int index) {
        return 0;
    }

    @Override
    protected int _getUnsignedMedium(int index) {
        return 0;
    }

    @Override
    protected int _getUnsignedMediumLE(int index) {
        return 0;
    }

    @Override
    protected int _getInt(int index) {
        return 0;
    }

    @Override
    protected int _getIntLE(int index) {
        return 0;
    }

    @Override
    protected long _getLong(int index) {
        return 0;
    }

    @Override
    protected long _getLongLE(int index) {
        return 0;
    }

    @Override
    protected void _setByte(int index, int value) {

    }

    @Override
    protected void _setShort(int index, int value) {

    }

    @Override
    protected void _setShortLE(int index, int value) {

    }

    @Override
    protected void _setMedium(int index, int value) {

    }

    @Override
    protected void _setMediumLE(int index, int value) {

    }

    @Override
    protected void _setInt(int index, int value) {

    }

    @Override
    protected void _setIntLE(int index, int value) {

    }

    @Override
    protected void _setLong(int index, long value) {

    }

    @Override
    protected void _setLongLE(int index, long value) {

    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public ByteBuf capacity(int newCapacity) {
        return null;
    }

    @Override
    public ByteBufAllocator alloc() {
        return null;
    }

    @Override
    public ByteOrder order() {
        return null;
    }

    @Override
    public ByteBuf unwrap() {
        return null;
    }

    @Override
    public boolean isDirect() {
        return false;
    }

    @Override
    public ByteBuf getBytes(int index, ByteBuf dst, int dstIndex, int length) {
        return null;
    }

    @Override
    public ByteBuf getBytes(int index, byte[] dst, int dstIndex, int length) {
        return null;
    }

    @Override
    public ByteBuf getBytes(int index, ByteBuffer dst) {
        return null;
    }

    @Override
    public ByteBuf getBytes(int index, OutputStream out, int length) throws IOException {
        return null;
    }

    @Override
    public int getBytes(int index, GatheringByteChannel out, int length) throws IOException {
        return 0;
    }

    @Override
    public int getBytes(int index, FileChannel out, long position, int length) throws IOException {
        return 0;
    }

    @Override
    public ByteBuf setBytes(int index, ByteBuf src, int srcIndex, int length) {
        return null;
    }

    @Override
    public ByteBuf setBytes(int index, byte[] src, int srcIndex, int length) {
        return null;
    }

    @Override
    public ByteBuf setBytes(int index, ByteBuffer src) {
        return null;
    }

    @Override
    public int setBytes(int index, InputStream in, int length) throws IOException {
        return 0;
    }

    @Override
    public int setBytes(int index, ScatteringByteChannel in, int length) throws IOException {
        return 0;
    }

    @Override
    public int setBytes(int index, FileChannel in, long position, int length) throws IOException {
        return 0;
    }

    @Override
    public ByteBuf copy(int index, int length) {
        return null;
    }

    @Override
    public int nioBufferCount() {
        return 0;
    }

    @Override
    public ByteBuffer nioBuffer(int index, int length) {
        return null;
    }

    @Override
    public ByteBuffer internalNioBuffer(int index, int length) {
        return null;
    }

    @Override
    public ByteBuffer[] nioBuffers(int index, int length) {
        return new ByteBuffer[0];
    }

    @Override
    public boolean hasArray() {
        return false;
    }

    @Override
    public byte[] array() {
        return new byte[0];
    }

    @Override
    public int arrayOffset() {
        return 0;
    }

    @Override
    public boolean hasMemoryAddress() {
        return false;
    }

    @Override
    public long memoryAddress() {
        return 0;
    }

    @Override
    public ByteBuf retain(int increment) {
        return null;
    }

    @Override
    public int refCnt() {
        return 0;
    }

    @Override
    public ByteBuf retain() {
        return null;
    }

    @Override
    public ByteBuf touch() {
        return null;
    }

    @Override
    public ByteBuf touch(Object hint) {
        return null;
    }

    @Override
    public boolean release() {
        return false;
    }

    @Override
    public boolean release(int decrement) {
        return false;
    }
}
