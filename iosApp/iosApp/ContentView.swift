import SwiftUI
import shared


struct ContentView: View {
    @ObservedObject var krepesViewModel = KrepesViewModel(repository: CrepesRepository())

    var body: some View {
        NavigationView {
            VStack {
                List(krepesViewModel.crepes, id: \.name) { crepe in
                    CrepeView(crepe: crepe)
                }
                .navigationBarTitle(Text("Crepes List"))
                .onAppear {
                    self.krepesViewModel.startObservingCrepesUpdates()
                }
            }
        }
    }
}

struct CrepeView: View {
    var crepe: Crepe

    var body: some View {
        HStack {
            VStack(alignment: .leading) {
                Text(crepe.name).font(.headline)
            }
        }
    }
}
