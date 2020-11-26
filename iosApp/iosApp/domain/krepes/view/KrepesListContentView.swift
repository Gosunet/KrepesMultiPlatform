import SwiftUI
import shared

struct KrepesListContentView: View {
    @ObservedObject var krepesViewModel = KrepesViewModel(repository: CrepesRepository())
    let delegate : KrepesNavigationDelegate?
    let city : City?
    
    var body: some View {
        VStack {
            List(krepesViewModel.crepes, id: \.name) { crepe in
                CrepeView(crepe: crepe)
            }
            .onAppear {
                self.krepesViewModel.startObservingCrepesUpdates(city:city!)
            }
        }
    }
}

struct CrepeView: View {
    var crepe: Crepe

    var body: some View {
        HStack {
            AsyncImageView(
                url: URL(string:"https://assets.afcdn.com/recipe/20180713/81162_w1024h768c1cx1944cy2592.jpg")!,
               placeholder: { Text("Loading ...") },
               image: { Image(uiImage: $0).resizable() }
            )
           .frame(idealHeight: 50)
                
            Text(crepe.name).font(.headline)
        }
    }
}
