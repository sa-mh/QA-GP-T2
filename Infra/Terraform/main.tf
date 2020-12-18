provider "aws" {
  region                  = "eu-west-1"
  shared_credentials_file = "/home/ubuntu/.aws/credentials"
}

resource "aws_key_pair" "sshKeyGen" {
  key_name   = "myKey"
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
  type               = "t2.micro"
  size               = 8
  subnet_id          = module.subnets.subnet_id
  security_group_ids = [module.securitygroups.ssh_id]
  tag1 = {
    Name = "Test-EC2"
  }
}
module "ec2-3" {
  source             = "./ec2"
  subnet_id          = module.subnets.subnet_id
  security_group_ids = [module.securitygroups.ssh_id]
  tag1 = {
    Name = "Nexus-EC2"
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
  subnetid = {
    subnet1 = module.subnets.subnet_id
    subnet2 = module.subnets.subnet2_id
    subnet3 = module.subnets.subnet3_id
  }
}

module "securitygroups" {
  source  = "./securitygroups"
  vpc_id  = module.vpc.vpc_id
  vpccidr = module.vpc.vpc_cidr
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
  rdsname            = "development-db"
}

module "rds-2" {
  source             = "./rds"
  vpc_id             = module.vpc.vpc_id
  rds_subnet_grp_id  = module.subnets.rds_subnet_grp_id
  security_group_ids = [module.securitygroups.ssh_id]
  rdsname            = "test-db"
}

module "eks" {
  source             = "./eks"
  subnet_id          = module.subnets.subnet_id
  subnet2_id         = module.subnets.subnet2_id
  subnet3_id         = module.subnets.subnet3_id
  security_group_ids = [module.securitygroups.ssh_id]
}


