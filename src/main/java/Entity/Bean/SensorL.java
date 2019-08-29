package Entity.Bean;

import java.util.List;
import java.util.Map;

public class SensorL {
    private String nwkAddr;
    private String parAddr;
    private String macAddr;
    private String funcList;

    public String getFuncList() {
        return funcList;
    }

    public void setFuncList(String funcList) {
        this.funcList = funcList;
    }

    public String getNwkAddr() {
        return nwkAddr;
    }

    public void setNwkAddr(String nwkAddr) {
        this.nwkAddr = nwkAddr;
    }

    public String getParAddr() {
        return parAddr;
    }

    public void setParAddr(String parAddr) {
        this.parAddr = parAddr;
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }


}
