import Foundation
import shared


class KrepesViewModel: ObservableObject {
    @Published var crepes = [Crepe]()

    private let repository: CrepesRepository
    init(repository: CrepesRepository) {
        self.repository = repository
    }

    func startObservingCrepesUpdates() {
        repository.startObservingCrepesUpdates(success: { data in
            self.crepes = data
        })
    }
}

