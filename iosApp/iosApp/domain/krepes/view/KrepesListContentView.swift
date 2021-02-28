import SwiftUI
import shared

struct KrepesListContentView: View {
    @ObservedObject var krepesViewModel : KrepesViewModel = Injector.getContainer().resolve(KrepesViewModel.self)!

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
        if URL(string:crepe.image) != nil {
            HStack {
                AsyncImageView(
                    url: URL(string:crepe.image)!,
                   placeholder: { Text("Loading ...") },
                   image: { Image(uiImage: $0).resizable() }
                )
               .frame(idealWidth: 50, idealHeight: 50)
           }

            Text(crepe.name).font(.headline)
        }
    }
}
