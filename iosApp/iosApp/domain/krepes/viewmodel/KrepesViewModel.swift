import Foundation
import shared
import KMPNativeCoroutinesAsync

class KrepesViewModel: ObservableObject {
    @Published var crepes = [Crepe]()

    var repository: CrepesRepository
    
    init(repository: CrepesRepository) {
        self.repository = repository
    }

    func startObservingCrepesUpdates(city:City) async {
        repository.getCrepes(city: city) { (crepes: [Crepe]?, error) in
            self.crepes = crepes!;
        }
    }
}

