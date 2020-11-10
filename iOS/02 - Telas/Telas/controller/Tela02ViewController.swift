//
//  Tela02ViewController.swift
//  Telas
//
//  Created by Valéria Cavalcanti on 10/11/20.
//

import UIKit

class Tela02ViewController: UIViewController {

    @IBOutlet weak var lbMensagem: UILabel!
    var mensagem: String?
    
    
    @IBAction func voltar(_ sender: Any) {
        self.dismiss(animated: true, completion: nil)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        
        if let mensagem = self.mensagem{
            self.lbMensagem.text = mensagem
        }
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(true)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(true)
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(true)
    }
    
}
