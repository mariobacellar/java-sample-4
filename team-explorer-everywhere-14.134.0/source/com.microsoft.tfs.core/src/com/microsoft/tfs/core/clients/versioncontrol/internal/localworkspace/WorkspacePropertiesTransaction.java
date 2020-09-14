// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

package com.microsoft.tfs.core.clients.versioncontrol.internal.localworkspace;

public interface WorkspacePropertiesTransaction {
    public void invoke(LocalWorkspaceProperties wp);
}
