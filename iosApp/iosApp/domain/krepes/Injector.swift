//
//  Injector.swift
//  iosApp
//
//  Created by Anthony Manach on 27/11/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import Swinject
import shared

class Injector{
    private static let container = Container()
    
    static func start(){
        container.register(CrepesRepository.self) { _ in CrepesRepository() }
        container.register(KrepesViewModel.self) { r in KrepesViewModel(repository: r.resolve(CrepesRepository.self)!) }
    }
    
    static func getContainer()->Container{
        return container
    }
}
