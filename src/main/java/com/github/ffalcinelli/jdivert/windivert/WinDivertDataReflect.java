package com.github.ffalcinelli.jdivert.windivert;

import com.sun.jna.Structure;
import com.sun.jna.platform.win32.WinDef;

import java.util.Arrays;
import java.util.List;

public class WinDivertDataReflect extends Structure {
    public long timestamp;
    public WinDef.UINT processId;
    public int layer;
    public WinDef.ULONG flags;
    public short priority;

    @Override
    protected List getFieldOrder() {
        return Arrays.asList(
                "timestamp",
                "processId",
                "layer",
                "flags",
                "priority");
    }
}
