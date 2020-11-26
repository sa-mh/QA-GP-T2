resource "aws_instance" "demo" {
  ami                         = var.ami-ROI
  instance_type               = var.type
  key_name                    = "terraKey"
  associate_public_ip_address = "true"
  subnet_id                   = var.subnet_id
  vpc_security_group_ids      = var.security_group_ids
  tags = {
    "Name": "Jenkins EC2"
  }
}

resource "aws_instance" "pyTestEC2" {
  ami                         = var.ami-ROI
  instance_type               = var.type
  key_name                    = "terraKey"
  associate_public_ip_address = "true"
  subnet_id                   = var.subnet_id
  vpc_security_group_ids      = var.security_group_ids
  tags = {
    "Name": "PyTest EC2"
  }
}
