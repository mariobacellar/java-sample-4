// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

package com.microsoft.tfs.core.clients.workitem.internal.query;

public interface PageCallback {
    public Object[] pageInItems(int startingIx, int length);
}
