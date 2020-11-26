//
//  KrepesCityListContentView.swift
//  iosApp
//
//  Created by Anthony Manach on 26/11/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct KrepesCityListView: View {
    
    let cities = [City.brest, City.rennes]
    let delegate : KrepesNavigationDelegate?
    
    var body: some View {
        VStack {
            ForEach(cities, id:\.name) { city in
                    Button(action: {
                        delegate?.goToKrepesList(city: city)
                    }){
                        Text("\(city.name)")
                    }
                }
            }
    }
}
