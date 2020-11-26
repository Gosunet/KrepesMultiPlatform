//
//  EnvironmentValues+ImageCache.swift
//  iosApp
//
//  Created by Anthony Manach on 25/11/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI

struct ImageCacheKey: EnvironmentKey {
    static let defaultValue: ImageCache = TemporaryImageCache()
}

extension EnvironmentValues {
    var imageCache: ImageCache {
        get { self[ImageCacheKey.self] }
        set { self[ImageCacheKey.self] = newValue }
    }
}
