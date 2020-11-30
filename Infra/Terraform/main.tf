provider "aws" {
  region                  = "eu-west-1"
  shared_credentials_file = "/home/ubuntu/.aws/credentials"
}

resource "aws_key_pair" "sshKeyGen" {
  key_name   = var.keyName
  public_key = var.pubKey
}

module "ec2" {
  source             = "./ec2"
  subnet_id          = module.subnets.subnet_id
  security_group_ids = [module.securitygroups.ssh_id]
  tag1 = {
    Name = "Jenkins-EC2"
  }
}

module "ec2-2" {
  source             = "./ec2"
  subnet_id          = module.subnets.subnet_id
  security_group_ids = [module.securitygroups.ssh_id]
  tag1 = {
    Name = "Test-EC2"
  }
}

module "gateway" {
  source = "./gateway"
  vpc_id = module.vpc.vpc_id
}

module "routetable" {
  source     = "./routetable"
  vpc_id     = module.vpc.vpc_id
  gateway_id = module.gateway.gateway_id
  subnet_id  = module.subnets.subnet_id
  subnet2_id = module.subnets.subnet2_id
  subnet3_id = module.subnets.subnet3_id
}

module "securitygroups" {
  source = "./securitygroups"
  vpc_id = module.vpc.vpc_id
}

module "subnets" {
  source = "./subnets"
  vpc_id = module.vpc.vpc_id
}

module "vpc" {
  source = "./vpc"
}

module "rds" {
  source             = "./rds"
  vpc_id             = module.vpc.vpc_id
  rds_subnet_grp_id  = module.subnets.rds_subnet_grp_id
  security_group_ids = [module.securitygroups.ssh_id]
}

module "rds2" {
  source             = "./rds"
  vpc_id             = module.vpc.vpc_id
  rds_subnet_grp_id  = module.subnets.rds_subnet_grp_id
  security_group_ids = [module.securitygroups.ssh_id]
}



// module "eks" {
//   source             = "./eks"
//   subnet_id          = module.subnets.subnet_id
//   subnet2_id         = module.subnets.subnet2_id
//   subnet3_id         = module.subnets.subnet3_id
//   security_group_ids = [module.securitygroups.ssh_id]
// }


