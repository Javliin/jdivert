package com.github.ffalcinelli.jdivert.windivert;

import com.sun.jna.Structure;
import com.sun.jna.platform.win32.WinDef;

import java.util.Arrays;
import java.util.List;

public class WinDivertDataFlow extends Structure {
    public WinDef.ULONG endpoint;
    public WinDef.ULONG parentEndpoint;
    public WinDef.UINT processId;
    public WinDef.UINT[] localAddr = new WinDef.UINT[4];;
    public WinDef.UINT[] remoteAddr = new WinDef.UINT[4];;
    public WinDef.USHORT localPort;
    public WinDef.USHORT remotePort;
    public byte protocol;

    @Override
    protected List getFieldOrder() {
        return Arrays.asList(
                "endpoint",
                "parentEndpoint",
                "processId",
                "localAddr",
                "remoteAddr",
                "localPort",
                "remotePort",
                "protocol");
    }
}
