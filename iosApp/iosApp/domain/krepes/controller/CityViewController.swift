//
//  ViewController.swift
//  Swift-Sample-UINavigationController
//
//  Created by A10 Lab Inc. 003 on 2018/04/18.
//  Copyright © 2018年 A10 Lab Inc. 003. All rights reserved.
//

import UIKit
import SwiftUI

class CityViewController: KrepesBaseViewController {
    override func viewDidLoad() {
        
        super.viewDidLoad()
        
        let contentView = KrepesCityListView(delegate:self.delegate)
         
        let hostingController = UIHostingController.init(rootView: contentView)
        addChild(hostingController)
        
        hostingController.didMove(toParent: self)
        
        view.addSubview(hostingController.view)
        
        
        hostingController.view.translatesAutoresizingMaskIntoConstraints = false
                NSLayoutConstraint.activate([
                    hostingController.view.topAnchor.constraint(equalTo: self.view.topAnchor),
                    hostingController.view.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
                    hostingController.view.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
                    hostingController.view.bottomAnchor.constraint(equalTo: self.view.bottomAnchor),
                ])
    }
}
