# Wi-Fi-Password

![Wi-Fi icon](/src/images/icons8_Wi-Fi_Lock_30px.png)

```java
private void refresh() {
    if (osName.startsWith("Windows")) {
        refreshInWindows();
    } else if (osName.equals("Linux")) {
        refreshInLinux();
    }
    fillNetworks(listOfNetworks);
}
```

This method refresh the networks then fill the list.
