package com.github.patsalyukas.device;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public interface Reliability {

    DeviceStatus checkDeviceStatus() throws NoSuchProviderException, NoSuchAlgorithmException;

}
