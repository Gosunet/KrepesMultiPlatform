//
//  ListViewControler.swift
//  iosApp
//
//  Created by Anthony Manach on 25/11/2020.
//  Copyright © 2020 orgName. All rights reserved.
//
import UIKit
import Foundation
import SwiftUI
import shared

class KrepesListViewController: KrepesBaseViewController {
    
    public var city : City
    
    init(delegate:KrepesNavigationDelegate, city : City){
        self.city=city
        super.init(delegate:delegate)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() {
        
        super.viewDidLoad()
        
        let contentView = KrepesListContentView(delegate:self.delegate, city:city)
        
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
