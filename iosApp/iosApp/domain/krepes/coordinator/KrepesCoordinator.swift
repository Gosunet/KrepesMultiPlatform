//
//  KrepesCoordinator.swift
//  iosApp
//
//  Created by Anthony Manach on 25/11/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import UIKit
import shared

class KrepesCoordinator: Coordinator, KrepesNavigationDelegate {
    var childCoordinators = [Coordinator]()
    var navigationController: UINavigationController

    init(navigationController: UINavigationController) {
        self.navigationController = navigationController
    }

    func start() {
        goToCitySelection()
    }
    
    func goToCitySelection(){
        let cityViewController = CityViewController(delegate:self)
        cityViewController.delegate=self
        self.navigationController.pushViewController(cityViewController, animated: true)
    }
    
    func goToKrepesList(city:City){
        let krepesListViewController = KrepesListViewController(delegate:self, city:city)
        krepesListViewController.delegate=self
        self.navigationController.pushViewController(krepesListViewController, animated: true)
    }
}

protocol KrepesNavigationDelegate {
    func goToCitySelection()
    func goToKrepesList(city:City)
}
