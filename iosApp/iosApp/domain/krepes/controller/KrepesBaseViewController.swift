//
//  KrepeBaseController.swift
//  iosApp
//
//  Created by Anthony Manach on 26/11/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import UIKit
import SwiftUI

class KrepesBaseViewController: UIViewController {
    
    internal var delegate : KrepesNavigationDelegate?
    
    init(delegate : KrepesNavigationDelegate){
        super.init(nibName: nil, bundle: nil)
        self.delegate = delegate
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
}

