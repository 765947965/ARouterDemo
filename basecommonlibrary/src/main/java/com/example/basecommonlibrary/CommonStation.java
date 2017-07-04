package com.example.basecommonlibrary;

import java.util.Random;

/**
 * @author: xiewenliang
 * @Filename:
 * @Description:
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2017/4/25 15:40
 */

public class CommonStation {
    public static final int CHECK_LOADING = 1;

    public static final int CHECK_TIME = CHECK_LOADING + 1;

    public static boolean checkLoading() {
        return new Random().nextBoolean();
    }

    public static boolean checkTime() {
        return new Random().nextBoolean();
    }
}
