//
//  Tela2ViewController.swift
//  Navigation Controller
//
//  Created by Valéria Cavalcanti on 01/12/20.
//

import UIKit

class Tela2ViewController: UIViewController {

    @IBOutlet weak var lbMensagem: UILabel!
    
    var mensagem: String?
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if (segue.identifier == "tela2_tela3"){
            let t3vc = segue.destination as! Tela3ViewController
            t3vc.mensagem = "Funciona 2 3"
        }
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        if let mensagem = self.mensagem{
            self.lbMensagem.text = mensagem
        }
    }
    
}
