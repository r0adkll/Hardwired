package com.r0adkll.hardwired.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data
 * Created by drew.heavner on 1/14/16.
 */
public class MockOhmData {

    public static Map<String, String> OHM_DATA = new HashMap<String, String>(){
        {
            put("http://192.168.1.204:8085/data.json", TEST_GAMING_MACHINE);
            put("http://192.168.1.193:8085/data.json", TEST_HTPC_MACHINE);
        }
    };

    public static final String TEST_HTPC_MACHINE = "{\n" +
            "   \"id\":0,\n" +
            "   \"Text\":\"Sensor\",\n" +
            "   \"Children\":[\n" +
            "      {\n" +
            "         \"id\":1,\n" +
            "         \"Text\":\"FIRENATION\",\n" +
            "         \"Children\":[\n" +
            "            {\n" +
            "               \"id\":2,\n" +
            "               \"Text\":\"ASUS H87I-PLUS\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":3,\n" +
            "                     \"Text\":\"Nuvoton NCT6791D\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":4,\n" +
            "                           \"Text\":\"Voltages\",\n" +
            "                           \"Children\":[\n" +
            "                              {\n" +
            "                                 \"id\":5,\n" +
            "                                 \"Text\":\"CPU VCore\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"0.864 V\",\n" +
            "                                 \"Value\":\"2.040 V\",\n" +
            "                                 \"Max\":\"2.040 V\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":6,\n" +
            "                                 \"Text\":\"Voltage #2\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"1.032 V\",\n" +
            "                                 \"Value\":\"2.040 V\",\n" +
            "                                 \"Max\":\"2.040 V\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":7,\n" +
            "                                 \"Text\":\"AVCC\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"3.328 V\",\n" +
            "                                 \"Value\":\"4.080 V\",\n" +
            "                                 \"Max\":\"4.080 V\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":8,\n" +
            "                                 \"Text\":\"3VCC\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"3.312 V\",\n" +
            "                                 \"Value\":\"4.080 V\",\n" +
            "                                 \"Max\":\"4.080 V\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":9,\n" +
            "                                 \"Text\":\"Voltage #5\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"0.992 V\",\n" +
            "                                 \"Value\":\"2.040 V\",\n" +
            "                                 \"Max\":\"2.040 V\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":10,\n" +
            "                                 \"Text\":\"Voltage #6\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"0.152 V\",\n" +
            "                                 \"Value\":\"2.040 V\",\n" +
            "                                 \"Max\":\"2.040 V\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":11,\n" +
            "                                 \"Text\":\"Voltage #7\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"0.840 V\",\n" +
            "                                 \"Value\":\"2.040 V\",\n" +
            "                                 \"Max\":\"2.040 V\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":12,\n" +
            "                                 \"Text\":\"3VSB\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"3.296 V\",\n" +
            "                                 \"Value\":\"4.080 V\",\n" +
            "                                 \"Max\":\"4.080 V\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":13,\n" +
            "                                 \"Text\":\"VBAT\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"3.312 V\",\n" +
            "                                 \"Value\":\"4.080 V\",\n" +
            "                                 \"Max\":\"4.080 V\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":14,\n" +
            "                                 \"Text\":\"VTT\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"1.008 V\",\n" +
            "                                 \"Value\":\"2.040 V\",\n" +
            "                                 \"Max\":\"2.040 V\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":15,\n" +
            "                                 \"Text\":\"Voltage #11\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"0.152 V\",\n" +
            "                                 \"Value\":\"2.040 V\",\n" +
            "                                 \"Max\":\"2.040 V\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":16,\n" +
            "                                 \"Text\":\"Voltage #12\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"0.128 V\",\n" +
            "                                 \"Value\":\"2.040 V\",\n" +
            "                                 \"Max\":\"2.040 V\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":17,\n" +
            "                                 \"Text\":\"Voltage #13\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"0.120 V\",\n" +
            "                                 \"Value\":\"2.040 V\",\n" +
            "                                 \"Max\":\"2.040 V\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":18,\n" +
            "                                 \"Text\":\"Voltage #14\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"0.120 V\",\n" +
            "                                 \"Value\":\"2.040 V\",\n" +
            "                                 \"Max\":\"2.040 V\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":19,\n" +
            "                                 \"Text\":\"Voltage #15\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"0.032 V\",\n" +
            "                                 \"Value\":\"2.040 V\",\n" +
            "                                 \"Max\":\"2.040 V\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              }\n" +
            "                           ],\n" +
            "                           \"Min\":\"\",\n" +
            "                           \"Value\":\"\",\n" +
            "                           \"Max\":\"\",\n" +
            "                           \"ImageURL\":\"images_icon/voltage.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":20,\n" +
            "                           \"Text\":\"Temperatures\",\n" +
            "                           \"Children\":[\n" +
            "                              {\n" +
            "                                 \"id\":21,\n" +
            "                                 \"Text\":\"CPU Core\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"27.5 °C\",\n" +
            "                                 \"Value\":\"30.0 °C\",\n" +
            "                                 \"Max\":\"54.0 °C\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":22,\n" +
            "                                 \"Text\":\"Temperature #1\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"-1.0 °C\",\n" +
            "                                 \"Value\":\"-1.0 °C\",\n" +
            "                                 \"Max\":\"35.0 °C\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":23,\n" +
            "                                 \"Text\":\"Temperature #2\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"-1.0 °C\",\n" +
            "                                 \"Value\":\"-1.0 °C\",\n" +
            "                                 \"Max\":\"118.0 °C\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":24,\n" +
            "                                 \"Text\":\"Temperature #3\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"-1.0 °C\",\n" +
            "                                 \"Value\":\"-1.0 °C\",\n" +
            "                                 \"Max\":\"34.5 °C\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":25,\n" +
            "                                 \"Text\":\"Temperature #4\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"-1.0 °C\",\n" +
            "                                 \"Value\":\"-1.0 °C\",\n" +
            "                                 \"Max\":\"113.0 °C\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":26,\n" +
            "                                 \"Text\":\"Temperature #5\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"-1.0 °C\",\n" +
            "                                 \"Value\":\"-1.0 °C\",\n" +
            "                                 \"Max\":\"111.0 °C\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":27,\n" +
            "                                 \"Text\":\"Temperature #6\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"-1.0 °C\",\n" +
            "                                 \"Value\":\"-1.0 °C\",\n" +
            "                                 \"Max\":\"111.0 °C\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              }\n" +
            "                           ],\n" +
            "                           \"Min\":\"\",\n" +
            "                           \"Value\":\"\",\n" +
            "                           \"Max\":\"\",\n" +
            "                           \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":28,\n" +
            "                           \"Text\":\"Fans\",\n" +
            "                           \"Children\":[\n" +
            "                              {\n" +
            "                                 \"id\":29,\n" +
            "                                 \"Text\":\"Fan #1\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"0 RPM\",\n" +
            "                                 \"Value\":\"65535 RPM\",\n" +
            "                                 \"Max\":\"65535 RPM\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":30,\n" +
            "                                 \"Text\":\"Fan #2\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"1080 RPM\",\n" +
            "                                 \"Value\":\"65535 RPM\",\n" +
            "                                 \"Max\":\"65535 RPM\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":31,\n" +
            "                                 \"Text\":\"Fan #3\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"0 RPM\",\n" +
            "                                 \"Value\":\"65535 RPM\",\n" +
            "                                 \"Max\":\"65535 RPM\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":32,\n" +
            "                                 \"Text\":\"Fan #4\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"0 RPM\",\n" +
            "                                 \"Value\":\"65535 RPM\",\n" +
            "                                 \"Max\":\"65535 RPM\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":33,\n" +
            "                                 \"Text\":\"Fan #5\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"0 RPM\",\n" +
            "                                 \"Value\":\"65535 RPM\",\n" +
            "                                 \"Max\":\"65535 RPM\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":34,\n" +
            "                                 \"Text\":\"Fan #6\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"0 RPM\",\n" +
            "                                 \"Value\":\"65535 RPM\",\n" +
            "                                 \"Max\":\"65535 RPM\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              }\n" +
            "                           ],\n" +
            "                           \"Min\":\"\",\n" +
            "                           \"Value\":\"\",\n" +
            "                           \"Max\":\"\",\n" +
            "                           \"ImageURL\":\"images_icon/fan.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":35,\n" +
            "                           \"Text\":\"Controls\",\n" +
            "                           \"Children\":[\n" +
            "                              {\n" +
            "                                 \"id\":36,\n" +
            "                                 \"Text\":\"Fan Control #1\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"100.0 %\",\n" +
            "                                 \"Value\":\"100.0 %\",\n" +
            "                                 \"Max\":\"100.0 %\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":37,\n" +
            "                                 \"Text\":\"Fan Control #2\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"23.9 %\",\n" +
            "                                 \"Value\":\"100.0 %\",\n" +
            "                                 \"Max\":\"100.0 %\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":38,\n" +
            "                                 \"Text\":\"Fan Control #3\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"100.0 %\",\n" +
            "                                 \"Value\":\"100.0 %\",\n" +
            "                                 \"Max\":\"100.0 %\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":39,\n" +
            "                                 \"Text\":\"Fan Control #4\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"100.0 %\",\n" +
            "                                 \"Value\":\"100.0 %\",\n" +
            "                                 \"Max\":\"100.0 %\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":40,\n" +
            "                                 \"Text\":\"Fan Control #5\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"100.0 %\",\n" +
            "                                 \"Value\":\"100.0 %\",\n" +
            "                                 \"Max\":\"100.0 %\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              },\n" +
            "                              {\n" +
            "                                 \"id\":41,\n" +
            "                                 \"Text\":\"Fan Control #6\",\n" +
            "                                 \"Children\":[\n" +
            "\n" +
            "                                 ],\n" +
            "                                 \"Min\":\"100.0 %\",\n" +
            "                                 \"Value\":\"100.0 %\",\n" +
            "                                 \"Max\":\"100.0 %\",\n" +
            "                                 \"ImageURL\":\"images/transparent.png\"\n" +
            "                              }\n" +
            "                           ],\n" +
            "                           \"Min\":\"\",\n" +
            "                           \"Value\":\"\",\n" +
            "                           \"Max\":\"\",\n" +
            "                           \"ImageURL\":\"images_icon/control.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/chip.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/mainboard.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":42,\n" +
            "               \"Text\":\"Intel Core i3-4130\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":43,\n" +
            "                     \"Text\":\"Clocks\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":44,\n" +
            "                           \"Text\":\"Bus Speed\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"100 MHz\",\n" +
            "                           \"Value\":\"100 MHz\",\n" +
            "                           \"Max\":\"100 MHz\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":45,\n" +
            "                           \"Text\":\"CPU Core #1\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"798 MHz\",\n" +
            "                           \"Value\":\"3392 MHz\",\n" +
            "                           \"Max\":\"3392 MHz\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":46,\n" +
            "                           \"Text\":\"CPU Core #2\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"798 MHz\",\n" +
            "                           \"Value\":\"3392 MHz\",\n" +
            "                           \"Max\":\"3392 MHz\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/clock.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":47,\n" +
            "                     \"Text\":\"Temperatures\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":48,\n" +
            "                           \"Text\":\"CPU Core #1\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"21.0 °C\",\n" +
            "                           \"Value\":\"27.0 °C\",\n" +
            "                           \"Max\":\"54.0 °C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":49,\n" +
            "                           \"Text\":\"CPU Core #2\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"24.0 °C\",\n" +
            "                           \"Value\":\"28.0 °C\",\n" +
            "                           \"Max\":\"56.0 °C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":50,\n" +
            "                           \"Text\":\"CPU Package\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"26.0 °C\",\n" +
            "                           \"Value\":\"30.0 °C\",\n" +
            "                           \"Max\":\"56.0 °C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":51,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":52,\n" +
            "                           \"Text\":\"CPU Total\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"0.0 %\",\n" +
            "                           \"Max\":\"99.6 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":53,\n" +
            "                           \"Text\":\"CPU Core #1\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"0.0 %\",\n" +
            "                           \"Max\":\"100.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":54,\n" +
            "                           \"Text\":\"CPU Core #2\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"0.0 %\",\n" +
            "                           \"Max\":\"100.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":55,\n" +
            "                     \"Text\":\"Powers\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":56,\n" +
            "                           \"Text\":\"CPU Package\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"2.5 W\",\n" +
            "                           \"Value\":\"2.8 W\",\n" +
            "                           \"Max\":\"1104.8 W\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":57,\n" +
            "                           \"Text\":\"CPU Cores\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 W\",\n" +
            "                           \"Value\":\"0.2 W\",\n" +
            "                           \"Max\":\"1125.0 W\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":58,\n" +
            "                           \"Text\":\"CPU Graphics\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 W\",\n" +
            "                           \"Value\":\"0.0 W\",\n" +
            "                           \"Max\":\"0.0 W\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":59,\n" +
            "                           \"Text\":\"CPU DRAM\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"1.8 W\",\n" +
            "                           \"Value\":\"1.8 W\",\n" +
            "                           \"Max\":\"1112.1 W\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/power.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/cpu.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":60,\n" +
            "               \"Text\":\"Generic Memory\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":61,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":62,\n" +
            "                           \"Text\":\"Memory\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"14.0 %\",\n" +
            "                           \"Value\":\"14.9 %\",\n" +
            "                           \"Max\":\"26.1 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":63,\n" +
            "                     \"Text\":\"Data\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":64,\n" +
            "                           \"Text\":\"Used Memory\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"1.7 GB\",\n" +
            "                           \"Value\":\"1.8 GB\",\n" +
            "                           \"Max\":\"3.1 GB\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":65,\n" +
            "                           \"Text\":\"Available Memory\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"8.8 GB\",\n" +
            "                           \"Value\":\"10.2 GB\",\n" +
            "                           \"Max\":\"10.3 GB\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/power.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/ram.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":66,\n" +
            "               \"Text\":\"AMD Radeon HD 6800 Series\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":67,\n" +
            "                     \"Text\":\"Voltages\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":68,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.950 V\",\n" +
            "                           \"Value\":\"0.950 V\",\n" +
            "                           \"Max\":\"1.150 V\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/voltage.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":69,\n" +
            "                     \"Text\":\"Clocks\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":70,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"100 MHz\",\n" +
            "                           \"Value\":\"300 MHz\",\n" +
            "                           \"Max\":\"820 MHz\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":71,\n" +
            "                           \"Text\":\"GPU Memory\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"300 MHz\",\n" +
            "                           \"Value\":\"300 MHz\",\n" +
            "                           \"Max\":\"1100 MHz\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/clock.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":72,\n" +
            "                     \"Text\":\"Temperatures\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":73,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"29.0 °C\",\n" +
            "                           \"Value\":\"30.0 °C\",\n" +
            "                           \"Max\":\"37.0 °C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":74,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":75,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"0.0 %\",\n" +
            "                           \"Max\":\"28.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":76,\n" +
            "                     \"Text\":\"Controls\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":77,\n" +
            "                           \"Text\":\"GPU Fan\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"40.0 %\",\n" +
            "                           \"Value\":\"40.0 %\",\n" +
            "                           \"Max\":\"40.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/control.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/ati.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":78,\n" +
            "               \"Text\":\"Generic Hard Disk\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":79,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":80,\n" +
            "                           \"Text\":\"Used Space\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"72.1 %\",\n" +
            "                           \"Value\":\"72.1 %\",\n" +
            "                           \"Max\":\"72.1 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/hdd.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":81,\n" +
            "               \"Text\":\"ST31500541AS\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":82,\n" +
            "                     \"Text\":\"Temperatures\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":83,\n" +
            "                           \"Text\":\"Temperature\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"21.0 °C\",\n" +
            "                           \"Value\":\"24.0 °C\",\n" +
            "                           \"Max\":\"27.0 °C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":84,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":85,\n" +
            "                           \"Text\":\"Used Space\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"21.9 %\",\n" +
            "                           \"Value\":\"21.9 %\",\n" +
            "                           \"Max\":\"21.9 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/hdd.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":86,\n" +
            "               \"Text\":\"WDC WD20EARX-008FB0\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":87,\n" +
            "                     \"Text\":\"Temperatures\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":88,\n" +
            "                           \"Text\":\"Temperature\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"18.0 °C\",\n" +
            "                           \"Value\":\"21.0 °C\",\n" +
            "                           \"Max\":\"23.0 °C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":89,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":90,\n" +
            "                           \"Text\":\"Used Space\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"99.4 %\",\n" +
            "                           \"Value\":\"99.4 %\",\n" +
            "                           \"Max\":\"99.4 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/hdd.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":91,\n" +
            "               \"Text\":\"WDC WD15EARS-00MVWB0\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":92,\n" +
            "                     \"Text\":\"Temperatures\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":93,\n" +
            "                           \"Text\":\"Temperature\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"20.0 °C\",\n" +
            "                           \"Value\":\"24.0 °C\",\n" +
            "                           \"Max\":\"26.0 °C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":94,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":95,\n" +
            "                           \"Text\":\"Used Space\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.2 %\",\n" +
            "                           \"Value\":\"0.2 %\",\n" +
            "                           \"Max\":\"0.2 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/hdd.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":96,\n" +
            "               \"Text\":\"Corsair Force LS SSD\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":97,\n" +
            "                     \"Text\":\"Temperatures\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":98,\n" +
            "                           \"Text\":\"Temperature\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"90.0 °C\",\n" +
            "                           \"Value\":\"90.0 °C\",\n" +
            "                           \"Max\":\"90.0 °C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":99,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":100,\n" +
            "                           \"Text\":\"Used Space\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"48.4 %\",\n" +
            "                           \"Value\":\"48.5 %\",\n" +
            "                           \"Max\":\"50.1 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/hdd.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":101,\n" +
            "               \"Text\":\"WDC WD1001FALS-00J7B0\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":102,\n" +
            "                     \"Text\":\"Temperatures\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":103,\n" +
            "                           \"Text\":\"Temperature\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"21.0 °C\",\n" +
            "                           \"Value\":\"29.0 °C\",\n" +
            "                           \"Max\":\"30.0 °C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":104,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":105,\n" +
            "                           \"Text\":\"Used Space\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"96.5 %\",\n" +
            "                           \"Value\":\"96.5 %\",\n" +
            "                           \"Max\":\"96.5 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/hdd.png\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"Min\":\"\",\n" +
            "         \"Value\":\"\",\n" +
            "         \"Max\":\"\",\n" +
            "         \"ImageURL\":\"images_icon/computer.png\"\n" +
            "      }\n" +
            "   ],\n" +
            "   \"Min\":\"Min\",\n" +
            "   \"Value\":\"Value\",\n" +
            "   \"Max\":\"Max\",\n" +
            "   \"ImageURL\":\"\"\n" +
            "}";

    public static final String TEST_GAMING_MACHINE = "{\n" +
            "   \"id\":0,\n" +
            "   \"Text\":\"Sensor\",\n" +
            "   \"Children\":[\n" +
            "      {\n" +
            "         \"id\":1,\n" +
            "         \"Text\":\"THEBATCOMPUTER\",\n" +
            "         \"Children\":[\n" +
            "            {\n" +
            "               \"id\":2,\n" +
            "               \"Text\":\"ASUS Z170-A\",\n" +
            "               \"Children\":[\n" +
            "\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/mainboard.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":3,\n" +
            "               \"Text\":\"Intel Core i5-6600K\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":4,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":5,\n" +
            "                           \"Text\":\"CPU Total\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.4 %\",\n" +
            "                           \"Value\":\"9.4 %\",\n" +
            "                           \"Max\":\"86.7 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":6,\n" +
            "                           \"Text\":\"CPU Core #1\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"21.9 %\",\n" +
            "                           \"Max\":\"100.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":7,\n" +
            "                           \"Text\":\"CPU Core #2\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"12.5 %\",\n" +
            "                           \"Max\":\"90.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":8,\n" +
            "                           \"Text\":\"CPU Core #3\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"3.1 %\",\n" +
            "                           \"Max\":\"90.6 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":9,\n" +
            "                           \"Text\":\"CPU Core #4\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"0.0 %\",\n" +
            "                           \"Max\":\"95.3 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/cpu.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":10,\n" +
            "               \"Text\":\"Generic Memory\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":11,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":12,\n" +
            "                           \"Text\":\"Memory\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"15.3 %\",\n" +
            "                           \"Value\":\"15.4 %\",\n" +
            "                           \"Max\":\"30.9 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":13,\n" +
            "                     \"Text\":\"Data\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":14,\n" +
            "                           \"Text\":\"Used Memory\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"2.4 GB\",\n" +
            "                           \"Value\":\"2.4 GB\",\n" +
            "                           \"Max\":\"4.9 GB\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":15,\n" +
            "                           \"Text\":\"Available Memory\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"11.0 GB\",\n" +
            "                           \"Value\":\"13.5 GB\",\n" +
            "                           \"Max\":\"13.5 GB\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/power.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/ram.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":16,\n" +
            "               \"Text\":\"AMD Radeon R9 200 Series\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":17,\n" +
            "                     \"Text\":\"Clocks\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":18,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"230 MHz\",\n" +
            "                           \"Value\":\"319 MHz\",\n" +
            "                           \"Max\":\"1000 MHz\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":19,\n" +
            "                           \"Text\":\"GPU Memory\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"150 MHz\",\n" +
            "                           \"Value\":\"1250 MHz\",\n" +
            "                           \"Max\":\"1250 MHz\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/clock.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":20,\n" +
            "                     \"Text\":\"Temperatures\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":21,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"37.0 Â°C\",\n" +
            "                           \"Value\":\"82.0 Â°C\",\n" +
            "                           \"Max\":\"94.0 Â°C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":22,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":23,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"0.0 %\",\n" +
            "                           \"Max\":\"100.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":24,\n" +
            "                     \"Text\":\"Fans\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":25,\n" +
            "                           \"Text\":\"GPU Fan\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"292 RPM\",\n" +
            "                           \"Value\":\"2052 RPM\",\n" +
            "                           \"Max\":\"2212 RPM\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/fan.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":26,\n" +
            "                     \"Text\":\"Controls\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":27,\n" +
            "                           \"Text\":\"GPU Fan\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"20.0 %\",\n" +
            "                           \"Value\":\"42.0 %\",\n" +
            "                           \"Max\":\"59.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/control.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/ati.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":28,\n" +
            "               \"Text\":\"AMD Radeon R9 200 Series\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":29,\n" +
            "                     \"Text\":\"Clocks\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":30,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"270 MHz\",\n" +
            "                           \"Value\":\"300 MHz\",\n" +
            "                           \"Max\":\"375 MHz\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                           \"id\":31,\n" +
            "                           \"Text\":\"GPU Memory\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"150 MHz\",\n" +
            "                           \"Value\":\"150 MHz\",\n" +
            "                           \"Max\":\"150 MHz\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/clock.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":32,\n" +
            "                     \"Text\":\"Temperatures\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":33,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"39.0 Â°C\",\n" +
            "                           \"Value\":\"46.0 Â°C\",\n" +
            "                           \"Max\":\"46.0 Â°C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":34,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":35,\n" +
            "                           \"Text\":\"GPU Core\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"0.0 %\",\n" +
            "                           \"Value\":\"0.0 %\",\n" +
            "                           \"Max\":\"0.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":36,\n" +
            "                     \"Text\":\"Fans\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":37,\n" +
            "                           \"Text\":\"GPU Fan\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"1036 RPM\",\n" +
            "                           \"Value\":\"1052 RPM\",\n" +
            "                           \"Max\":\"1785 RPM\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/fan.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":38,\n" +
            "                     \"Text\":\"Controls\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":39,\n" +
            "                           \"Text\":\"GPU Fan\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"20.0 %\",\n" +
            "                           \"Value\":\"20.0 %\",\n" +
            "                           \"Max\":\"59.0 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/control.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/ati.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":40,\n" +
            "               \"Text\":\"Samsung SSD 850 EVO 250GB\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":41,\n" +
            "                     \"Text\":\"Temperatures\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":42,\n" +
            "                           \"Text\":\"Temperature\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"27.0 Â°C\",\n" +
            "                           \"Value\":\"33.0 Â°C\",\n" +
            "                           \"Max\":\"34.0 Â°C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":43,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":44,\n" +
            "                           \"Text\":\"Used Space\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"53.2 %\",\n" +
            "                           \"Value\":\"53.2 %\",\n" +
            "                           \"Max\":\"53.4 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/hdd.png\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":45,\n" +
            "               \"Text\":\"WDC WD2003FZEX-00Z4SA0\",\n" +
            "               \"Children\":[\n" +
            "                  {\n" +
            "                     \"id\":46,\n" +
            "                     \"Text\":\"Temperatures\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":47,\n" +
            "                           \"Text\":\"Temperature\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"28.0 Â°C\",\n" +
            "                           \"Value\":\"29.0 Â°C\",\n" +
            "                           \"Max\":\"30.0 Â°C\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/temperature.png\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"id\":48,\n" +
            "                     \"Text\":\"Load\",\n" +
            "                     \"Children\":[\n" +
            "                        {\n" +
            "                           \"id\":49,\n" +
            "                           \"Text\":\"Used Space\",\n" +
            "                           \"Children\":[\n" +
            "\n" +
            "                           ],\n" +
            "                           \"Min\":\"26.7 %\",\n" +
            "                           \"Value\":\"26.7 %\",\n" +
            "                           \"Max\":\"26.7 %\",\n" +
            "                           \"ImageURL\":\"images/transparent.png\"\n" +
            "                        }\n" +
            "                     ],\n" +
            "                     \"Min\":\"\",\n" +
            "                     \"Value\":\"\",\n" +
            "                     \"Max\":\"\",\n" +
            "                     \"ImageURL\":\"images_icon/load.png\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"Min\":\"\",\n" +
            "               \"Value\":\"\",\n" +
            "               \"Max\":\"\",\n" +
            "               \"ImageURL\":\"images_icon/hdd.png\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"Min\":\"\",\n" +
            "         \"Value\":\"\",\n" +
            "         \"Max\":\"\",\n" +
            "         \"ImageURL\":\"images_icon/computer.png\"\n" +
            "      }\n" +
            "   ],\n" +
            "   \"Min\":\"Min\",\n" +
            "   \"Value\":\"Value\",\n" +
            "   \"Max\":\"Max\",\n" +
            "   \"ImageURL\":\"\"\n" +
            "}";

}
