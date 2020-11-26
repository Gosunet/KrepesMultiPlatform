//
//  Coordinator.swift
//  iosApp
//
//  Created by Anthony Manach on 25/11/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import UIKit

protocol Coordinator {
    var childCoordinators: [Coordinator] { get set }
    var navigationController: UINavigationController { get set }

    func start()
}
